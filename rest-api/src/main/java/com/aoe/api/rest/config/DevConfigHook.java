package com.aoe.api.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by joey on 16-7-20.
 */
@Configuration
@Profile({"dev","ut"})
public class DevConfigHook {
}
