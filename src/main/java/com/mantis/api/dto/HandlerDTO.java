package com.mantis.api.dto;

public class HandlerDTO {

    private String name;

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public HandlerDTO(String name) {
        this.setName(name);
    }
}
