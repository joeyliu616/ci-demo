
package com.aoe.api.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;


/**
 * Created by joey on 16-8-5.
 */

@Configuration
public class SessionConfig {
    @Bean
    HeaderHttpSessionStrategy sessionStrategy() {
        HeaderHttpSessionStrategy headerHttpSessionStrategy = new HeaderHttpSessionStrategy();
        headerHttpSessionStrategy.setHeaderName("X-Auth-Token");
        return headerHttpSessionStrategy;
    }
}

