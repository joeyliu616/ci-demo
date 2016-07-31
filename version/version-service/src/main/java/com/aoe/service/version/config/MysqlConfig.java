package com.aoe.service.version.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * Created by joey on 16-7-26.
 */
@Configuration
@Profile({"it","qa","staging","product"})
@PropertySource("version-mysql.properties")
public class MysqlConfig {

    private static final Logger logger = LoggerFactory.getLogger(MysqlConfig.class);
    
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;


    @PostConstruct
    public void afterInit(){
        logger.info("===> {},{},{}",url,userName,password);

    }

}
