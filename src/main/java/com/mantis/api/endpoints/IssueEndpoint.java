package com.mantis.api.endpoints;

import com.mantis.api.data.IssueDataTest;
import com.mantis.api.data.ProjectDataTest;
import com.mantis.api.dto.MinimalIssueDTO;
import com.mantis.api.dto.ProjectDTO;
import com.mantis.api.utils.SharedData;
import com.mantis.api.utils.Specs;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class IssueEndpoint {

    static int ISSUE_ID;

    public void postMinimalIssue() {

        ProjectEndpoint projectEndpoint = new ProjectEndpoint();
        ProjectDTO projectDTOCriacao = ProjectDataTest.setValue();

        projectEndpoint.backgroundPostProject(projectDTOCriacao);

        ProjectDTO projectDTO = SharedData.get("projectDTO");
        MinimalIssueDTO minimalIssueDTO = IssueDataTest.setValueMinimalIssue(projectDTO);

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
            System.err.println("Falha no teste postMinimalIssue(): " + error.getMessage());
            throw error;
        }
    }

    public void getAllIssues() {
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
        MinimalIssueDTO minimalIssueDTO = IssueDataTest.setValueMinimalIssue(projectDTO);
        backgroundPostIssue(minimalIssueDTO);

        //Consulta da Issue cadastrada
        given()
                .spec(Specs.authSpec())
                .when()
                .get("/api/rest/issues/" + ISSUE_ID)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("issues[0].summary", equalTo(minimalIssueDTO.getSummary()))
                .body("issues[0].description", equalTo(minimalIssueDTO.getDescription()))
        ;

    }

    public void backgroundPostIssue(MinimalIssueDTO minimalIssueDTO) {

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
    }
}