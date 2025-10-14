package com.mantis.api.dto;

public class ViewStateDTO {

    private String name;

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public ViewStateDTO() {}

    public ViewStateDTO(String name) {
        this.setName(name);
    }
}