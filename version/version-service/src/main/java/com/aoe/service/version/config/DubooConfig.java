package com.aoe.service.version.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Created by joey on 16-7-26.
 */
@Configuration
@Profile({"it","qa","staging","product"})
@ImportResource("classpath:dubbo/version-service-provider.xml")
public class DubooConfig {

    private static final Logger logger = LoggerFactory.getLogger(DubooConfig.class);

    @PostConstruct
    public void afterInit(){
        logger.info("----");
    }
}
