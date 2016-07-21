package com.aoe.service.version.impl;

import com.aoe.service.version.api.VersionService;
import com.aoe.service.version.api.dto.VersionInfo;
import com.aoe.service.version.entity.Version;
import com.aoe.service.version.jpa.VersionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by joey on 16-7-20.
 */
@Service("versionService")
public class VersionServiceImpl implements VersionService {

    @Resource
    VersionRepository versionRepository;

    @Override
    public VersionInfo getLatestVersion() {
        Version version = versionRepository.findOne(1L);
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setReleaseTime(version.getCreateTime());
        String info = version.getMajor() + "." + version.getMinor() + "." + version.getRevision() + "." + version.getBuild();
        versionInfo.setVersion(info);
        return versionInfo;
    }


}
