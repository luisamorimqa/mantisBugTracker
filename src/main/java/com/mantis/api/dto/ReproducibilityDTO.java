package com.mantis.api.dto;

public class ReproducibilityDTO {

    private String name;

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public ReproducibilityDTO(String name) {
        this.setName(name);
    }
}
