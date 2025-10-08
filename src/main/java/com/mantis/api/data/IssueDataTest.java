package com.mantis.api.data;

import com.mantis.api.dto.CategoryDTO;
import com.mantis.api.dto.MinimalIssueDTO;
import com.mantis.api.dto.ProjectDTO;
import com.mantis.api.utils.SharedData;

import static com.mantis.api.utils.DataFaker.*;

public class IssueDataTest {

    public static MinimalIssueDTO setValueMinimalIssue(ProjectDTO projectDTO) {

        MinimalIssueDTO minimalIssueDTO = new MinimalIssueDTO();
        CategoryDTO categoryDTO = new CategoryDTO("General");

        minimalIssueDTO.setSummary(getRandomString());
        minimalIssueDTO.setDescription(getRandomParagraph());
        minimalIssueDTO.setCategory(categoryDTO);
        minimalIssueDTO.setProject(projectDTO);

        SharedData.put("minimalIssueDTO", minimalIssueDTO);
        return minimalIssueDTO;
    }
}