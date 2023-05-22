package com.andersenlab.people.spec;

import com.andersenlab.people.config.PropertiesConfig;
import com.andersenlab.people.helpers.CustomAllureListener;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.with;

public class Specification {
    public static RequestSpecification requestSpecification = with()
            .filter(CustomAllureListener.withCustomTemplates())
            .log().uri()
            .log().body()
            .contentType(ContentType.JSON)
            .baseUri(PropertiesConfig.PROP.getApiBaseUrl());

    public static ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.BODY)
            .log(LogDetail.STATUS)
            .build();

    public static void initSpecification(RequestSpecification requestSpecification, ResponseSpecification responseSpecification){
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
