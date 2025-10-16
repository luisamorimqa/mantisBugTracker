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

    @Test
    @DisplayName("POST /api/rest/projects/ -> Deve adicionar um novo projeto")
    public void deveAddUmNovoProjeto() {
        projectEndpoint.postProject();
    }

    @Test
    @DisplayName("POST /api/rest/projects/ -> Não deve conseguir adicionar um novo projeto")
    public void naoDeveAdicionarNovoProjeto() {
        projectEndpoint.postProjectWithoutAutSpec();
    }

    @Test
    @DisplayName("GET /api/rest/projects/ -> Deve retornar o projeto buscado")
    public void deveRetornarOProjetoBuscado() {
        projectEndpoint.getExistentProject();
    }

    @Test
    @DisplayName("DELETE /api/rest/projects/ -> Deve deletar o projeto")
    public void deveDeletarOProjto() {
        projectEndpoint.deleteProject();
    }
}