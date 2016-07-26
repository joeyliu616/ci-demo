package com.aoe.api.rest.controller;

import com.aoe.service.version.Launcher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by joey on 16-7-26.
 */
@Configuration
@Import(Launcher.class)
public class UTConfig {
}
