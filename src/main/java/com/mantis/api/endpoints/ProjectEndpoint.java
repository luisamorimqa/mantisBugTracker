package com.mantis.api.endpoints;

import com.mantis.api.utils.Specs;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProjectEndpoint {

    public void getAllProjects() {

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
        } catch(AssertionError error) {
            System.err.println("Falha no teste getAllProjects(): " + error.getMessage());
            throw error;
        }
    }
}