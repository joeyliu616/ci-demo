package com.aoe.service.version.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * Created by joey on 16-7-23.
 */
@Profile({"dev","ut"})
@Configuration
@PropertySource({"classpath:version-h2.properties"})
public class H2Config {
    private static final Logger logger = LoggerFactory.getLogger(H2Config.class);
    @PostConstruct
    public void afterInit(){
        logger.info("--------");
    }
}
