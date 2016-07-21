package com.aoe.service.version;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by joey on 16-7-20.
 */
@Configuration
@Profile({"dev","ut"})
@EnableAutoConfiguration
@ComponentScan
public class VersionServiceDevConfigHook {

    private static Logger logger = LoggerFactory.getLogger(VersionServiceDevConfigHook.class);

    @PostConstruct
    public void info(){
        logger.info("--------------- ");
    }
}
