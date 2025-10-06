package com.mantis.api.dto;

public class PriorityDTO {

    private String name;

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public PriorityDTO(String name) {
        this.name = name;
    }
}
