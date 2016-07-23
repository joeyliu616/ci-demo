package com.aoe.api.rest.config;

import com.aoe.service.version.VersionServiceDevConfigHook;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Created by joey on 16-7-20.
 */
@Configuration
@Profile({"dev","ut"})
@Import({VersionServiceDevConfigHook.class})
public class DevConfigHook {
}
