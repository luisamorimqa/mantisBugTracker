package com.mantis.api.endpoints;

import com.mantis.api.data.ProjectDataTest;
import com.mantis.api.dto.ProjectDTO;
import com.mantis.api.utils.Specs;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProjectEndpoint {

    static int PROJECT_ID;

    public void getAllProjects() {
        //Consulta de todos os Projetos cadastrados
        try {
            given()
                    .spec(Specs.authSpec())
                    .when()
                    .get("/api/rest/projects")
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("projects", hasSize(greaterThan(0)))
            ;
        } catch (AssertionError error) {
            System.err.println("Falha no teste getAllProjects(): " + error.getMessage());
            throw error;
        }
    }

    public void postProject() {
        //Preenchimento do DTO que será usado para criação do projeto
        ProjectDTO projectDTO = ProjectDataTest.setValue();
        //Execução de requisição de criação de projeto
        try {
            given()
                    .spec(Specs.authSpec())
                    .body(projectDTO)
                    .when()
                    .post("/api/rest/projects/")
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("project.name", equalTo(projectDTO.getName()))
                    .body("project.status.name", equalTo(projectDTO.getStatus().getName()))
                    .body("project.description", equalTo(projectDTO.getDescription()))
                    .body("project.enabled", equalTo(projectDTO.getEnabled()))
                    .body("project.view_state.name", equalTo(projectDTO.getViewState().getName()))
            ;
        } catch (AssertionError error) {
            //Em caso de qualquer exceção, a mensagem será exibida
            System.err.println("Falha no teste postProject(): " + error.getMessage());
            throw error;
        }
    }

    public void getExistentProject() {
        //Criação do DTO que será usado para a criação do projeto
        ProjectDTO projectDTO = ProjectDataTest.setValue();
        backgroundPostProject(projectDTO);
        //Requisição para a criação do projeto
        try {
            given()
                    .spec(Specs.authSpec())
                    .when()
                    .get("/api/rest/projects/" + PROJECT_ID)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("projects[0].name", equalTo(projectDTO.getName()))
                    .body("projects[0].status.name", equalTo(projectDTO.getStatus().getName()))
                    .body("projects[0].description", equalTo(projectDTO.getDescription()))
                    .body("projects[0].enabled", equalTo(projectDTO.getEnabled()))
                    .body("projects[0].view_state.name", equalTo(projectDTO.getViewState().getName()))
            ;
        } catch (AssertionError error) {
            //Em caso de qualquer exceção, a mensagem será exibida
            System.err.println("Falha no teste getExistentProject(): " + error.getMessage());
            throw error;
        }
    }

    public void deleteProject() {
        //Criação do DTO que será usado para a criação do projeto
        ProjectDTO projectDTO = ProjectDataTest.setValue();
        //Criação do projeto que será usado para o teste de deleção
        backgroundPostProject(projectDTO);

        try {
            given()
                    .spec(Specs.authSpec())
                    .when()
                    .delete("/api/rest/projects/" + PROJECT_ID)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .statusLine(equalTo("HTTP/1.1 200 Project with id " + PROJECT_ID + " deleted."))
            ;
        } catch (AssertionError error) {
            //Em caso de qualquer exceção, a mensagem será exibida
            System.err.println("Falha no teste deleteProject(): " + error.getMessage());
            throw error;
        }
    }

    public void backgroundPostProject(ProjectDTO projectDTO) {
        //Criação de projeto e obtenção do ID para utilização em outros testes
        PROJECT_ID =
                given()
                        .spec(Specs.authSpec())
                        .body(projectDTO)
                        .when()
                        .post("/api/rest/projects/")
                        .then()
                        .log().all()
                        .extract().path("project.id")
        ;
    }
}