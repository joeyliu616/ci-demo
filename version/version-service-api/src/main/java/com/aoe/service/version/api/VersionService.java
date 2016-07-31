package com.aoe.service.version.api;

import com.aoe.service.version.api.dto.VersionInfo;

/**
 * Created by joey on 16-7-20.
 */
public interface VersionService {
    VersionInfo getLatestVersion();
}
