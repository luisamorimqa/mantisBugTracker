package com.mantis.api.dto;

public class AccessLevelDTO {

    private String name;

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public AccessLevelDTO(String value) {
        this.setName(value);
    }
}
