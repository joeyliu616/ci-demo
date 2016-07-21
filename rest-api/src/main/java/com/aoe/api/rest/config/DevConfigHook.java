package com.aoe.api.rest.config;

import com.aoe.service.version.VersionServiceDevConfigHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by joey on 16-7-20.
 */
@Configuration
@Profile({"dev","ut"})
@Import({VersionServiceDevConfigHook.class})
public class DevConfigHook {

    private static final Logger logger = LoggerFactory.getLogger(DevConfigHook.class);


    @PostConstruct
    public void info(){
        logger.info("----");
    }
}
