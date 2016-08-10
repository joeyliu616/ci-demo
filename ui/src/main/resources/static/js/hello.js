angular.module('hello', [ 'ngRoute' ]).config(function($routeProvider, $httpProvider) {

    $routeProvider.when('/', {
        templateUrl : 'home.html',
        controller : 'home',
        controllerAs : 'controller'
    }).when('/login', {
        templateUrl : 'login.html',
        controller : 'navigation',
        controllerAs : 'controller'
    }).when('/foo',{
        templateUrl : 'foo.html',
        controller: 'foo',
        controllerAs:'controller'
    }).otherwise('/');

    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

    //如果完成了认证, 在请求报头加上X-Auth-Token
    $httpProvider.interceptors.push(function($q, $rootScope){
        return {
            'request': function(config) {
                if(null != $rootScope.token){
                    config.headers['X-Auth-Token'] = $rootScope.token;
                }
                return config;
            }

        };
    });


}).controller('navigation',

    function($rootScope, $http, $location, $route) {

        var self = this;

        self.tab = function(route) {
            return $route.current && route === $route.current.controller;
        };

        var authenticate = function(credentials, callback) {

            if($rootScope.token == null){

                var headers = credentials ? {
                    authorization : "Basic "
                    + btoa(credentials.username + ":"
                    + credentials.password)
                } : {};

                $http.get('http://localhost:9000/user', {headers : headers})
                    .then(function(response) {
                        if (response.data.name) {
                            $rootScope.authenticated = true;
                            $rootScope.token = response.headers('X-Auth-Token');
                            console.log(JSON.stringify(response));
                        } else {
                            $rootScope.authenticated = false;
                            $rootScope.token = null;
                        }
                        callback && callback();
                    }, function() {
                        if($rootScope.token == null){
                            $rootScope.authenticated = false;
                        }

                        callback && callback();
                    });
            }


        }

        authenticate();

        self.credentials = {};
        self.login = function() {
            $rootScope.token = null;
            authenticate(self.credentials, function() {
                if ($rootScope.authenticated) {
                    console.log("Login succeeded");
                    $location.path("/");
                    self.error = false;
                    $rootScope.authenticated = true;
                } else {
                    console.log("Login failed");
                    $location.path("/login");
                    self.error = true;
                    $rootScope.authenticated = false;
                }
            })
        };

        self.logout = function() {
            $http.post('http://localhost:9000/logout',{}).finally(function() {
                $rootScope.authenticated = false;
                $rootScope.token = null;
                $location.path("/");
            });
        }

    }).controller('home', function($http) {
        var self = this;
        $http.get('http://localhost:9000/token')
            .then(function(response) {
            console.log("token response:" +JSON.stringify(response));
            $http({
                url : 'http://localhost:9000',
                method : 'GET'
            }).then(function(response) {
                console.log("9000 response" +JSON.stringify(response))
                self.greeting = response.data;
            });
        })
    }).controller('foo',function(){});