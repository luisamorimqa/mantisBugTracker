package com.mantis.api.data;

import com.mantis.api.dto.ProjectDTO;
import com.mantis.api.dto.StatusDTO;

import static com.mantis.api.utils.DataFaker.*;

public class ProjectDataTest {

    public static ProjectDTO setValue() {
        ProjectDTO projectDTO = new ProjectDTO();
        StatusDTO statusDTO = new StatusDTO();

        statusDTO.setName(getProjectStatus());

        projectDTO.setName(getRandomString());
        projectDTO.setStatus(statusDTO);

        return projectDTO;
    }
}
