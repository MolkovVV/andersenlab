package com.andersenlab.people.tests.api;

import com.andersenlab.people.endpoints.Endpoints;
import com.andersenlab.people.models.request.UserLoginModelRequest;
import com.andersenlab.people.models.response.ListResourcesModelResponse;
import com.andersenlab.people.models.response.UserLoginModelResponse;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;

import static com.andersenlab.people.spec.Specification.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("ALL")
public class ApiTests {
    @BeforeEach
    public void setSpec(){
        initSpecification(requestSpecification, responseSpecification);
    }

    @Tag("API")
    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void successUserRegister(){
        Gson gson = new Gson();
        UserLoginModelRequest userLoginModelRequest = new UserLoginModelRequest();
        userLoginModelRequest.setEmail("eve.holt@reqres.in");
        userLoginModelRequest.setPassword("pistol");

        UserLoginModelResponse response = step ("Выпролнить запрос", () ->
                given()
                        .spec(requestSpecification)
                        .body(userLoginModelRequest)
                        .when()
                        .post(Endpoints.registerUserPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().as(UserLoginModelResponse.class));

        step("Проверить что поле 'token' в теле ответа не пустое", () ->
                Assertions.assertTrue(response.getToken() != null,"token is null!"));
        step("verify token value in response", () ->
                Assertions.assertEquals(response.getToken(),"QpwL5tke4Pnpja7X4","Token not valid!"));
        step("Проверить поле 'id' в теле ответа", () ->
                Assertions.assertEquals(response.getId(),4,"id not valid"));
        gson.toJson(response);
        step("Проверить что тело ответа соответствует Json-Scheme", () ->
                assertThat(gson.toJson(response),matchesJsonSchemaInClasspath("schemes/registerUserScheme.json")));
    }

    @Tag("API")
    @Test
    @DisplayName("Получение ресурсов")
    public void getListResources(){
        ListResourcesModelResponse response = step ("Выполнить запрос", () ->
                given()
                        .spec(requestSpecification)
                        .when()
                        .get(Endpoints.lisResourcesPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().as(ListResourcesModelResponse.class));
        step ("Проверить номер страницы в теле ответа", () ->
                Assertions.assertTrue(response.getPage() == 1, "Number page doesn`t match"));
        step ("Провреить кол-во ресурсов в ответе", () ->
                Assertions.assertEquals(response.getData().size(),6,"Missing source!"));
    }
}
