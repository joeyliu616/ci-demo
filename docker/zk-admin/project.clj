(defproject zk-web "0.1.0-SNAPSHOT"
			:mirrors {"central" {:name "central"
                       :url "http://192.168.199.232:8081/content/groups/public"}}
            :description "FIXME: write this!"
            :dependencies [[org.clojure/clojure "1.4.0"]
                           [noir "1.3.0-beta3"]
                           [com.netflix.curator/curator-framework "1.1.16"]
                           [com.netflix.curator/curator-test "1.1.16"]]
            :main zk-web.server)
