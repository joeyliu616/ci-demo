package com.aoe.api.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

/**
 * Created by joey on 16-7-20.
 */
@Configuration
@Profile({"it"})
@ImportResource("classpath:dubbo/rest-api-consumer.xml")
public class ITConfigHook {
}
