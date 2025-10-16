package com.mantis.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    private String username;
    private String password;
    @JsonProperty("real_name")
    private String realName;
    private String email;
    @JsonProperty("access_level")
    private AccessLevelDTO accessLevelDTO;
    private boolean enabled;
    private boolean _protected;

    public void setUsername(String value) {
        this.username = value;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRealName(String value) {
        this.realName = value;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getEmail() {
        return this.email;
    }

    public void setAccessLevelDTO(AccessLevelDTO value) {
        this.accessLevelDTO = value;
    }

    public AccessLevelDTO getAccessLevelDTO() {
        return this.accessLevelDTO;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setProtected(boolean value) {
        this._protected = value;
    }

    public boolean getProtected() {
        return this._protected;
    }
}