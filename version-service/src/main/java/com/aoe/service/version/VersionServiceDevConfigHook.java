package com.aoe.service.version;

import com.aoe.service.version.config.LiquibaseDevConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Created by joey on 16-7-20.
 */
@Configuration
@Profile({"dev","ut"})
@Import(LiquibaseDevConfig.class)
@ComponentScan("com.aoe.service.version")
public class VersionServiceDevConfigHook {

    private static Logger logger = LoggerFactory.getLogger(VersionServiceDevConfigHook.class);
}
