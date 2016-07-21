package com.aoe.service.version.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by joey on 16-7-20.
 */
@Entity
@Table(name="t_version")
public class Version implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="major",nullable = false)
    private Integer major;
    @Column(name="minor",nullable = false)
    private Integer minor;
    @Column(name="revision",nullable = false)
    private Integer revision;
    @Column(name = "build",nullable = false)
    private String build;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name="create_time",nullable = false)
    private Date createTime;

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
