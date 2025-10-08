package com.mantis.api.dto;

public class CategoryDTO {

    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public CategoryDTO(String name) {
        this.setName(name);
    }

    public CategoryDTO(String id, String name) {
        this.setId(id);
        this.setName(name);
    }
}
