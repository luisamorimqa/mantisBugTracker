package com.mantis.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectDTO {

    private String id;
    private String name;
    private StatusDTO status;
    private String description;
    private String filePath;
    @JsonProperty("view_state")
    private ViewStateDTO viewState;
    private boolean enabled;

    public ProjectDTO() {}

    public ProjectDTO(String id) {
        this.setId(id);
    }

    public ProjectDTO(String id, String name, StatusDTO status, String description,
                      String filePath, ViewStateDTO viewState, boolean enabled) {
        this.setId(id);
        this.setName(name);
        this.setStatus(status);
        this.setDescription(description);
        this.setFilePath(filePath);
        this.setViewState(viewState);
        this.setEnabled(enabled);
    }

    public void setId(String value) {
        this.id = value;
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

    public void setStatus(StatusDTO value) {
        this.status = value;
    }

    public StatusDTO getStatus() {
        return this.status;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setFilePath(String value) {
        this.filePath = value;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setViewState(ViewStateDTO value) {
        this.viewState = value;
    }

    public ViewStateDTO getViewState() {
        return this.viewState;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public boolean getEnabled() {
        return this.enabled;
    }
}