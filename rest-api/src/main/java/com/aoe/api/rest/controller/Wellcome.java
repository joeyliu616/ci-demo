package com.aoe.api.rest.controller;


import com.aoe.service.version.api.VersionService;
import com.aoe.service.version.api.dto.VersionInfo;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by joey on 16-7-20.
 */
@RestController
public class Wellcome {

    @Resource
    VersionService versionService;

    @RequestMapping("/api/version")
    public VersionInfo showVersion(){
        return versionService.getLatestVersion();
    }
}
