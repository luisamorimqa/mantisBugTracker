package com.mantis.api.dto;

public class SeverityDTO {

    private String name;

    private void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public SeverityDTO(String name) {
        this.setName(name);
    }
}
