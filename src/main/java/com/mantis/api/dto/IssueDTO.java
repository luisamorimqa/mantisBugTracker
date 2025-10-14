package com.mantis.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueDTO {

    private String summary;
    private String description;
    @JsonProperty("additional_information")
    private String additionalInformation;
    @JsonProperty("project")
    private ProjectDTO projectDTO;
    @JsonProperty("category")
    private CategoryDTO categoryDTO;
    @JsonProperty("handler")
    private HandlerDTO handlerDTO;
    @JsonProperty("view_state")
    private ViewStateDTO viewStateDTO;
    @JsonProperty("priority")
    private PriorityDTO priorityDTO;
    @JsonProperty("severity")
    private SeverityDTO severityDTO;
    @JsonProperty("reproducibility")
    private ReproducibilityDTO reproducibilityDTO;
    private boolean sticky;
    private TagDTO[] tags;

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

    public void setAdditionalInformation(String value) {
        this.additionalInformation = value;
    }

    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    public void setProjectDTO(ProjectDTO value) {
        this.projectDTO = value;
    }

    public ProjectDTO getProjectDTO() {
        return this.projectDTO;
    }

    public void setCategoryDTO(CategoryDTO value) {
        this.categoryDTO = value;
    }

    public CategoryDTO getCategoryDTO() {
        return this.categoryDTO;
    }

    public void setHandlerDTO(HandlerDTO value) {
        this.handlerDTO = value;
    }

    public HandlerDTO getHandlerDTO() {
        return this.handlerDTO;
    }

    public void setViewStateDTO(ViewStateDTO value) {
        this.viewStateDTO = value;
    }

    public ViewStateDTO getViewStateDTO() {
        return this.viewStateDTO;
    }

    public void setPriorityDTO(PriorityDTO value) {
        this.priorityDTO = value;
    }

    public PriorityDTO getPriorityDTO() {
        return this.priorityDTO;
    }

    public void setSeverityDTO(SeverityDTO value) {
        this.severityDTO = value;
    }

    public SeverityDTO getSeverityDTO() {
        return this.severityDTO;
    }

    public void setReproducibilityDTO(ReproducibilityDTO value) {
        this.reproducibilityDTO = value;
    }

    public ReproducibilityDTO getReproducibilityDTO() {
        return this.reproducibilityDTO;
    }

    public void setSticky(boolean value) {
        this.sticky = value;
    }

    public boolean getSticky() {
        return this.sticky;
    }

    public void setTags(TagDTO[] value) {
        this.tags = value;
    }

    public TagDTO[] getTags() {
        return this.tags;
    }

    public IssueDTO() {}

    public IssueDTO(String summary,
                    String description,
                    String additionalInformation,
                    ProjectDTO projectDTO,
                    CategoryDTO categoryDTO,
                    HandlerDTO handlerDTO,
                    ViewStateDTO viewStateDTO,
                    PriorityDTO priorityDTO,
                    SeverityDTO severityDTO,
                    ReproducibilityDTO reproducibilityDTO,
                    boolean sticky,
                    TagDTO[] tags) {
        this.setSummary(summary);
        this.setDescription(description);
        this.setAdditionalInformation(additionalInformation);
        this.setProjectDTO(projectDTO);
        this.setCategoryDTO(categoryDTO);
        this.setHandlerDTO(handlerDTO);
        this.setViewStateDTO(viewStateDTO);
        this.setPriorityDTO(priorityDTO);
        this.setSeverityDTO(severityDTO);
        this.setReproducibilityDTO(reproducibilityDTO);
        this.setSticky(sticky);
        this.setTags(tags);
    }
}
