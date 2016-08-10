package com.aoe.api.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

/**
 * Created by joey on 16-8-5.
 */
@RestController
public class Auth {

    @RequestMapping("/user")
    @CrossOrigin(origins="*", maxAge=3600, allowedHeaders = "*")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/token")
    @CrossOrigin(origins="*", maxAge=3600,allowedHeaders = "*")
    @ResponseBody
    public Map<String,String> token(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
    }
}
