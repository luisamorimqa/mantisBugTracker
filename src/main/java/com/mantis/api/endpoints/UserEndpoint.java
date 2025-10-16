package com.mantis.api.endpoints;

import com.mantis.api.data.UserDataTest;
import com.mantis.api.dto.UserDTO;
import com.mantis.api.utils.Specs;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserEndpoint {

    static int USER_ID;

    public void postUser() {
        //Preenchimento do DTO que será usado para criação do usuário
        UserDTO userDTO = UserDataTest.setValue();
        //Execução de requisição de criação de usuário
        try {
            given()
                    .spec(Specs.authSpec())
                    .body(userDTO)
                    .when()
                    .post("/api/rest/users/")
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("user.name", equalTo(userDTO.getUsername()))
                    .body("user.real_name", equalTo(userDTO.getRealName()))
                    .body("user.email", equalTo(userDTO.getEmail()))
                    .body("user.access_level.name", equalTo(userDTO.getAccessLevelDTO().getName()))
                    ;
        } catch(AssertionError error) {
            System.err.println("Falha no teste postUser(): " + error.getMessage());
            throw error;
        }
    }

    public void postUserWithoutAutSpec() {
        //Preenchimento do DTO que será usado para a criação do usuário
        UserDTO userDTO = UserDataTest.setValue();
        //Execução de requisição de criação de usuário
        try {
            given()
                    .spec(Specs.withoutAuthSpec())
                    .body(userDTO)
                    .when()
                    .post("/api/rest/users/")
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_UNAUTHORIZED)
                    .statusLine("HTTP/1.1 401 API token required")
                    ;
        } catch(AssertionError error) {
            System.err.println("Falha no teste postUserWithoutAutSpec(): " + error.getMessage());
            throw error;
        }
    }

    public void resetPasswordUser() {


    }

    public void deleteUserProtected() {
        //Preenchimento do DTO que será usado para criação do usuário
        UserDTO userDTO = UserDataTest.setValue();
        userDTO.setProtected(true);
        //Execução de requisição de criação de usuário
        backgroundPostUser(userDTO);
        try {
            given()
                    .spec(Specs.authSpec())
                    .when()
                    .delete("/api/rest/users/" + USER_ID)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .body("message", equalTo("User protected."))
                    ;
        } catch(AssertionError error) {
            System.err.println("Falha no teste deleteUserProtected(): " + error.getMessage());
            throw error;
        }
    }

    public void deleteUserNonProtected() {
        //Preenchimento do DTO que será usado para a criação do usuário
        UserDTO userDTO = UserDataTest.setValue();
        userDTO.setProtected(false);
        //Execução de requisição de criação de usuário
        backgroundPostUser(userDTO);

        try {
            given()
                    .spec(Specs.authSpec())
                    .when()
                    .delete("/api/rest/users/" + USER_ID)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_NO_CONTENT)
                    ;
        } catch (AssertionError error) {
            System.err.println("Falha no teste deleteUserNonProtected(): " + error.getMessage());
            throw error;
        }
    }

    public void backgroundPostUser(UserDTO userDTO) {
        //Criação de usuário e obtenção de USERNAME para utilização em outros testes
        try {
            USER_ID =
            given()
                    .spec(Specs.authSpec())
                    .body(userDTO)
                    .when()
                    .post("/api/rest/users/")
                    .then()
                    .extract().path("user.id")
            ;
            System.out.println("################ Criei o usuário ##################################");
        } catch(AssertionError error) {
            System.err.println("Falha ao executar backgroundPostUser(): " + error.getMessage());
            throw error;
        }
    }
}