package com.hualala.qa.k8s.op.model.gen.pojo;

import java.util.Date;

public class Agent {
    private Long id;

    private String name;

    private String description;

    private Byte type;

    private Long app_id;

    private Long tier_id;

    private String token;

    private Integer config_version;

    private String agent_fingerprint;

    private Date last_health_check_time;

    private Byte status;

    private Byte enabled;

    private Byte is_visible;

    private Byte is_deleted;

    private Date create_time;

    private Date update_time;

    private String original_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getApp_id() {
        return app_id;
    }

    public void setApp_id(Long app_id) {
        this.app_id = app_id;
    }

    public Long getTier_id() {
        return tier_id;
    }

    public void setTier_id(Long tier_id) {
        this.tier_id = tier_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getConfig_version() {
        return config_version;
    }

    public void setConfig_version(Integer config_version) {
        this.config_version = config_version;
    }

    public String getAgent_fingerprint() {
        return agent_fingerprint;
    }

    public void setAgent_fingerprint(String agent_fingerprint) {
        this.agent_fingerprint = agent_fingerprint == null ? null : agent_fingerprint.trim();
    }

    public Date getLast_health_check_time() {
        return last_health_check_time;
    }

    public void setLast_health_check_time(Date last_health_check_time) {
        this.last_health_check_time = last_health_check_time;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public Byte getIs_visible() {
        return is_visible;
    }

    public void setIs_visible(Byte is_visible) {
        this.is_visible = is_visible;
    }

    public Byte getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Byte is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name == null ? null : original_name.trim();
    }
}