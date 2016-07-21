package com.aoe.service.version.impl;

import com.aoe.service.version.VersionServiceDevConfigHook;
import com.aoe.service.version.entity.Version;
import com.aoe.service.version.jpa.VersionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by joey on 16-7-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VersionServiceDevConfigHook.class)
public class VersionServiceImplTest extends AbstractTestNGSpringContextTests {

    @Resource
    VersionRepository versionRepository;


    ObjectMapper objectMapper = new ObjectMapper();

    @DataProvider
    public Object[][] versionList(){
        return new Object[][]{
                new Object[]{1,2,3,"alpha"},
                new Object[]{1,0,3,"beta"},
                new Object[]{1,0,3,null}
        };
    }

    @Test
    public void testGetLatestVersion() throws Exception {
        Assert.notNull(versionRepository);
    }

    @Test(dataProvider = "versionList")
    public void testSave(Integer major, Integer minor, Integer reversion, String build){
        Version version = new Version();
        version.setCreateTime(new Date());
        Assert.notNull(major);
        Assert.notNull(minor);
        Assert.notNull(reversion);
        String buildInfo = null;
        if(StringUtils.isEmpty(build)){
            build = "snapshot";
            buildInfo = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        }else{
            buildInfo = build;
        }

        version.setBuild(build);
        version.setMajor(major);
        version.setMinor(minor);
        version.setRevision(reversion);
        version.setName(major+"." + minor + "." + reversion + "-" + buildInfo);
        Version save = versionRepository.save(version);
        Assert.notNull(versionRepository.findOne(save.getId()));
    }


    @Test(dependsOnMethods =  "testSave")
    public void testFindLatest() throws JsonProcessingException {
        Version v1 = versionRepository.findTopByOrderByNameDesc();
        Assert.notNull(v1);
        logger.info(objectMapper.writeValueAsString(v1));
        List<Version> all = versionRepository.findAll(new Sort(Sort.Direction.DESC,"name"));
        Assert.notEmpty(all);
        logger.info(objectMapper.writeValueAsString(all));
    }
}