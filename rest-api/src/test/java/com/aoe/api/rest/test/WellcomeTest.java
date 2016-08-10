package com.aoe.api.rest.test;

import com.aoe.api.rest.RestAPILauncher;
import com.aoe.service.version.api.dto.VersionInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;


/**
 * Created by joey on 16-7-20.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RestAPILauncher.class,UTConfig.class}
        ,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WellcomeTest {
    private static Logger logger = LoggerFactory.getLogger(WellcomeTest.class);

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Resource
    ObjectMapper objectMapper;

    @Value("${local.server.port}")
    int port;

    @Test
    public void testAuthentication() throws JsonProcessingException {
        ResponseEntity<VersionInfo> entity = testRestTemplate.getForEntity("http://localhost:" + port + "/api/version", VersionInfo.class);
        Assert.notNull(entity);
        Assert.notNull(entity.getBody());
        logger.info(entity.getStatusCode().toString());
        Assert.isTrue(entity.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
        logger.info(objectMapper.writeValueAsString(entity));
    }


    @Test
    public void testShowVersion() throws Exception {

    }
}
