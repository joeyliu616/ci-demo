
package com.aoe.api.rest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.StaticHeadersWriter;


/**
 * Created by joey on 16-8-3.
 */
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    private static final Logger logger = LoggerFactory.getLogger(SpringSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .logout().and()
                .cors().and()
                .authorizeRequests()
                    .anyRequest().authenticated().and()
                .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .and()
                .headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Expose-Headers","X-Auth-Token"));

    }

}

