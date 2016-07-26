package com.aoe.api.rest.controller;

import com.aoe.api.rest.RestAPILauncher;
import com.aoe.api.rest.config.DevConfigHook;
import com.aoe.service.version.api.dto.VersionInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Created by joey on 16-7-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RestAPILauncher.class,UTConfig.class})
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class WellcomeTest {

    private static Logger logger = LoggerFactory.getLogger(WellcomeTest.class);

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Resource
    ObjectMapper objectMapper;

    @Value("${local.server.port}")
    int port;

    @Test
    public void testShowVersion() throws Exception {
        ResponseEntity<VersionInfo> entity = testRestTemplate.getForEntity("http://localhost:" + port + "/api/version", VersionInfo.class);
        Assert.notNull(entity);
        Assert.notNull(entity.getBody());
        logger.info(objectMapper.writeValueAsString(entity));
    }
}