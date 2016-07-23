package com.aoe.service.version;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by joey on 16-7-20.
 */
@Configuration
@Profile({"dev","ut"})
@EnableAutoConfiguration
public class VersionServiceDevConfigHook {

    private static Logger logger = LoggerFactory.getLogger(VersionServiceDevConfigHook.class);
}
