package com.mantis.api.dto;

public class MinimalIssueDTO {

    private String summary;
    private String description;
    private CategoryDTO category;
    private ProjectDTO project;

    public void setSummary(String value) {
        this.summary = value;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCategory(CategoryDTO value) {
        this.category = value;
    }

    public CategoryDTO getCategory() {
        return this.category;
    }

    public void setProject(ProjectDTO value) {
        this.project = value;
    }

    public ProjectDTO getProject() {
        return this.project;
    }
}