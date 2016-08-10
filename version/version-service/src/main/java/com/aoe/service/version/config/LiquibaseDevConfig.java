package com.aoe.service.version.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * Created by joey on 16-7-23.
 */
@Configuration
@PropertySource({"classpath:version-liquibase.properties"})
public class LiquibaseDevConfig {
    private static final Logger logger = LoggerFactory.getLogger(LiquibaseDevConfig.class);

    @Value("${liquibase.change-log}")
    String changeLogPath;
    @PostConstruct
    public void foo(){

        logger.info("--- "+changeLogPath);
    }
}
