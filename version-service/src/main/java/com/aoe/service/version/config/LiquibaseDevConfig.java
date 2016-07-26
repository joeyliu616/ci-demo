package com.aoe.service.version.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by joey on 16-7-23.
 */
@Configuration
@PropertySource({"classpath:version-liquibase.properties"})
public class LiquibaseDevConfig {
}
