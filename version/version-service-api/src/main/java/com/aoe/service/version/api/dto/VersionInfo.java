package com.aoe.service.version.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by joey on 16-7-20.
 */
public class VersionInfo implements Serializable {

    @JsonProperty
    public String version;
    @JsonProperty
    public Date ReleaseTime;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getReleaseTime() {
        return ReleaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        ReleaseTime = releaseTime;
    }
}
