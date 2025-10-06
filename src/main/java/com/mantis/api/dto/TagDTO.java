package com.mantis.api.dto;

public class TagDTO {

    private String name;

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public TagDTO(String name) {
        this.setName(name);
    }
}
