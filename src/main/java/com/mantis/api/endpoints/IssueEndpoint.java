package com.mantis.api.endpoints;

import com.mantis.api.data.IssueDataTest;
import com.mantis.api.data.ProjectDataTest;
import com.mantis.api.dto.IssueDTO;
import com.mantis.api.dto.ProjectDTO;
import com.mantis.api.utils.SharedData;
import com.mantis.api.utils.Specs;
import org.apache.http.HttpStatus;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class IssueEndpoint {

    static int ISSUE_ID;

    public void postIssue() {
        //Instância do endpoint
        ProjectEndpoint projectEndpoint = new ProjectEndpoint();
        //Preenchimento do DTO que será usado para criação do projeto
        ProjectDTO projectDTOCriacao = ProjectDataTest.setValue();
        //Criação do projeto
        projectEndpoint.backgroundPostProject(projectDTOCriacao);
        //Busca de informações usadas para a criação do projeto
        ProjectDTO projectDTO = SharedData.get("projectDTO");
        //Criação do DTO que será usado para a criação da issue, já com os dados do projeto criado
        IssueDTO issueDTO = IssueDataTest.setIssueValue(projectDTO);
        //Execução de requisição de criação da Issue
        try {
            given()
                    .spec(Specs.authSpec())
                    .body(issueDTO)
                    .log().all()
                    .when()
                    .post("/api/rest/issues/")
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_CREATED)
            ;
        } catch (AssertionError error) {
            //Em caso de qualquer exceção, a mensagem será exibida
            System.err.println("Falha no teste postIssue(): " + error.getMessage());
            throw error;
        }
    }

    public void postMinimalIssue() {
        //Instância do endpoint
        ProjectEndpoint projectEndpoint = new ProjectEndpoint();
        //Preenchimento do DTO que será usado para criação do projeto
        ProjectDTO projectDTOCriacao = ProjectDataTest.setValue();
        //Criação do projeto
        projectEndpoint.backgroundPostProject(projectDTOCriacao);
        //Busca de informações usadas para a criação do projeto
        ProjectDTO projectDTO = SharedData.get("projectDTO");
        //Criação do DTO que será usado para a criação da issue, já com os dados do projeto criado
        IssueDTO minimalIssueDTO = IssueDataTest.setMinimalIssueValue(projectDTO);
        //Execução de requisição de criação da Issue
        try {
            given()
                    .spec(Specs.authSpec())
                    .body(minimalIssueDTO)
                    .log().all()
                    .when()
                    .post("/api/rest/issues/")
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_CREATED)
            ;
        } catch (AssertionError error) {
            //Em caso de qualquer exceção, a mensagem será exibida
            System.err.println("Falha no teste postMinimalIssue(): " + error.getMessage());
            throw error;
        }
    }

    public void getAllIssues() {
        //Consulta de todas as Issues cadastradas
        try {
            given()
                    .spec(Specs.authSpec())
                    .when()
                    .get("/api/rest/issues")
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("issues", hasSize(greaterThan(0)))
            ;
        } catch (AssertionError error) {
            //Em caso de qualquer exceção, a mensagem será exibida
            System.err.println("Falha no teste getAllIssues(): " + error.getMessage());
            throw error;
        }
    }

    public void getAnIssue() {
        //Criação do projeto para a criação da Issue
        ProjectEndpoint projectEndpoint = new ProjectEndpoint();
        ProjectDTO projectDTOCriacao = ProjectDataTest.setValue();
        projectEndpoint.backgroundPostProject(projectDTOCriacao);
        ProjectDTO projectDTO = SharedData.get("projectDTO");

        //Criação da Issue
        IssueDTO issueDTO = IssueDataTest.setIssueValue(projectDTO);
        backgroundPostIssue(issueDTO);

        try {
            //Consulta da Issue cadastrada
            given()
                    .spec(Specs.authSpec())
                    .when()
                    .get("/api/rest/issues/" + ISSUE_ID)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("issues[0].summary", equalTo(issueDTO.getSummary()))
                    .body("issues[0].description", equalTo(issueDTO.getDescription()))
            ;
        } catch (AssertionError error) {
            //Em caso de qualquer exceção, a mensagem será exibida
            System.err.println("Falha no teste getAnIssue(): " + error.getMessage());
            throw error;
        }
    }

    public void patchIssue() {
        //Criação do projeto para a criação da Issue
        ProjectEndpoint projectEndpoint = new ProjectEndpoint();
        ProjectDTO projectDTOCriacao = ProjectDataTest.setValue();
        projectEndpoint.backgroundPostProject(projectDTOCriacao);

        IssueDTO issueDTO = IssueDataTest.setIssueValue(projectDTOCriacao);
        backgroundPostIssueMinimal(issueDTO);

        IssueDTO issueDTOPatch = issueDTO;
        issueDTOPatch.setSummary(issueDTO.getSummary() + " Alterado");

        try {
            given()
                    .spec(Specs.authSpec())
                    .body(issueDTOPatch)
                    .when()
                    .patch("/api/rest/issues/" + ISSUE_ID)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("issues[0].summary", equalTo(issueDTOPatch.getSummary()))
                    ;
        } catch(AssertionError error) {
            System.err.println("Falha no teste patchIssue(): " + error.getMessage());
            throw error;
        }
    }

    public void deleteAnIssue() {
        //Criação do projeto para a criação da Issue
        ProjectEndpoint projectEndpoint = new ProjectEndpoint();
        ProjectDTO projectDTOCriacao = ProjectDataTest.setValue();
        projectEndpoint.backgroundPostProject(projectDTOCriacao);
        ProjectDTO projectDTO = SharedData.get("projectDTO");

        //Criação da Issue
        IssueDTO issueDTO = IssueDataTest.setIssueValue(projectDTO);
        backgroundPostIssue(issueDTO);

        try {
            //Teste de deleção da issue cadastrada
            given()
                    .spec(Specs.authSpec())
                    .when()
                    .delete("/api/rest/issues/" + ISSUE_ID)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_NO_CONTENT)
                    .statusLine(equalTo("HTTP/1.1 204 No Content"))
            ;

        } catch (AssertionError error) {
            System.err.println("Falha no teste deleteAnIssue(): " + error.getMessage());
            throw error;
        }
    }

    public void backgroundPostIssueMinimal(IssueDTO minimalIssueDTO) {
        try {
            //Criação de Issue e obtenção do ID para utilização em outros testes
            ISSUE_ID =
                    given()
                            .spec(Specs.authSpec())
                            .body(minimalIssueDTO)
                            .when()
                            .post("/api/rest/issues/")
                            .then()
                            .log().all()
                            .extract().path("issue.id")
            ;
        } catch(Exception exception) {
            throw new RuntimeException("Falha no método backgroundPOstIssueMinimal(): ", exception);
        }
    }

    public void backgroundPostIssue(IssueDTO issueDTO) {
        try {
            ISSUE_ID =

                    given()
                            .spec(Specs.authSpec())
                            .body(issueDTO)
                            .log().all()
                            .when()
                            .post("/api/rest/issues/")
                            .then()
                            .log().all()
                            .extract().path("issue.id")
            ;
        } catch(Exception exception) {
            throw new RuntimeException("Falha no método backgroundPostIssue(): ", exception);
        }
    }
}