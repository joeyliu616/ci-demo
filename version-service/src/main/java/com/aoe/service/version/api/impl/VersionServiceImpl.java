package com.aoe.service.version.api.impl;

import com.aoe.service.version.api.VersionService;
import com.aoe.service.version.api.dto.VersionInfo;
import com.aoe.service.version.entity.Version;
import com.aoe.service.version.jpa.VersionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by joey on 16-7-20.
 */
@Service("versionService")
public class VersionServiceImpl implements VersionService {

    @Resource
    VersionRepository versionRepository;

    @Override
    public VersionInfo getLatestVersion() {
        Version v1 = versionRepository.findTopByOrderByNameDesc();
        if(null != v1){
            VersionInfo versionInfo = new VersionInfo();
            versionInfo.setReleaseTime(v1.getCreateTime());
            versionInfo.setVersion(v1.getName());
            return versionInfo;
        }
        return new VersionInfo();
    }

}
