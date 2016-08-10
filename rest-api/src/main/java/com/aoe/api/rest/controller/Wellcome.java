package com.aoe.api.rest.controller;


import com.aoe.api.rest.dto.Message;
import com.aoe.service.version.api.VersionService;
import com.aoe.service.version.api.dto.VersionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by joey on 16-7-20.
 */
@RestController
public class Wellcome {

    private static final Logger logger = LoggerFactory.getLogger(Wellcome.class);
    
    @Resource
    VersionService versionService;

    @RequestMapping("/")
    @CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = { "x-auth-token", "x-requested-with" })
    public Message home(){
        return new Message("hello world");
    }

    @RequestMapping("/api/version")
    @CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = { "x-auth-token", "x-requested-with" })
    public VersionInfo showVersion(){
        return versionService.getLatestVersion();
    }
}