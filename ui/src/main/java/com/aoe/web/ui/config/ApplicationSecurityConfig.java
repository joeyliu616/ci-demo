package com.aoe.web.ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

/**
 * Created by joey on 16-8-4.
 */
@Configuration
public class ApplicationSecurityConfig {

    @Configuration
    class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
                    .and()
                .authorizeRequests()
                    .anyRequest().authenticated().and()
                .csrf()
                    //check csrf token by cookie
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        }
    }

    //will check X-Auth-Token for session validation
    @Bean
    HeaderHttpSessionStrategy sessionStrategy() {
        HeaderHttpSessionStrategy headerHttpSessionStrategy = new HeaderHttpSessionStrategy();
        headerHttpSessionStrategy.setHeaderName("X-Auth-Token");
        return headerHttpSessionStrategy;
    }
}
