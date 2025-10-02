package Funcional;

import com.mantis.api.endpoints.ProjectEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProjectTest {

    ProjectEndpoint projectEndpoint = new ProjectEndpoint();

    @Test
    @DisplayName("GET /api/rest/projects/ -> Deve retornar todos os projetos cadastrados")
    public void deveRetornarTodosOsProjetosCadastrados() {
        projectEndpoint.getAllProjects();
    }
}
