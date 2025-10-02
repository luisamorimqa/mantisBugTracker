package com.mantis.api.data;

import com.mantis.api.dto.ProjectDTO;
import com.mantis.api.dto.StatusDTO;
import com.mantis.api.dto.ViewStateDTO;
import com.mantis.api.utils.SharedData;

import static com.mantis.api.utils.DataFaker.*;

public class ProjectDataTest {

    public static ProjectDTO setValue() {
        ProjectDTO projectDTO = new ProjectDTO();
        StatusDTO statusDTO = new StatusDTO();
        ViewStateDTO viewStateDTO = new ViewStateDTO();

        statusDTO.setName(getProjectStatus());
        viewStateDTO.setName(getProjectViewState());

        projectDTO.setName(getRandomString());
        projectDTO.setStatus(statusDTO);
        projectDTO.setDescription(getRandomParagraph());
        projectDTO.setFilePath("/" + getRandomString() + "/");
        projectDTO.setViewState(viewStateDTO);
        projectDTO.setEnabled(getProjectEnabled());

        SharedData.put("projectDTO", projectDTO);
        return projectDTO;
    }
}