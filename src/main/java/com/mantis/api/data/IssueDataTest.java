package com.mantis.api.data;

import com.mantis.api.dto.*;
import com.mantis.api.utils.SharedData;
import org.yaml.snakeyaml.nodes.Tag;

import static com.mantis.api.utils.DataFaker.*;

public class IssueDataTest {

    public static IssueDTO setMinimalIssueValue(ProjectDTO projectDTO) {
        IssueDTO minimalIssueDTO = new IssueDTO();
        CategoryDTO categoryDTO = new CategoryDTO("bugtracker");

        minimalIssueDTO.setSummary("asda");
        minimalIssueDTO.setDescription("descr");
        minimalIssueDTO.setCategoryDTO(categoryDTO);
        minimalIssueDTO.setProjectDTO(projectDTO);

        SharedData.put("minimalIssueDTO", minimalIssueDTO);
        return minimalIssueDTO;
    }

    public static IssueDTO setIssueValue(ProjectDTO projectDTO) {
        IssueDTO issueDTO = new IssueDTO();
        CategoryDTO categoryDTO = new CategoryDTO(getRandomIssueCategory());
        HandlerDTO handlerDTO = new HandlerDTO(getRandomHandler());
        ViewStateDTO viewStateDTO = new ViewStateDTO(getRandomProjectViewState());
        PriorityDTO priorityDTO = new PriorityDTO(getRandomPriority());
        SeverityDTO severityDTO = new SeverityDTO(getRandomSeverity());
        ReproducibilityDTO reproducibilityDTO = new ReproducibilityDTO(getRandomReproducibility());
        TagDTO tag1 = new TagDTO(getRandomTagName());
        TagDTO[] tags = new TagDTO[] {tag1};

        issueDTO.setSummary(getRandomString());
        issueDTO.setDescription(getRandomParagraph());
        issueDTO.setProjectDTO(projectDTO);
        issueDTO.setCategoryDTO(categoryDTO);
        issueDTO.setHandlerDTO(handlerDTO);
        issueDTO.setViewStateDTO(viewStateDTO);
        issueDTO.setPriorityDTO(priorityDTO);
        issueDTO.setSeverityDTO(severityDTO);
        issueDTO.setReproducibilityDTO(reproducibilityDTO);
        issueDTO.setSticky(getRandomBoolean());
        issueDTO.setTags(tags);

        SharedData.put("issueDTO", issueDTO);
        return issueDTO;
    }
}