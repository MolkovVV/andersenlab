package com.andersenlab.people.helpers.browserstack;

import com.andersenlab.people.helpers.browserstack.models.BrowserStackSessionInfo;

import static com.andersenlab.people.config.PropertiesConfig.PROP;
import static io.restassured.RestAssured.given;

public class BrowserStackHelper {
    public static BrowserStackSessionInfo getSessionInfo(String sessionId) {
        return given()
                .baseUri("https://api.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .auth().basic(PROP.getBrowserStackUser(), PROP.getBrowserStackPassword())
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().as(BrowserStackSessionInfo.class);
    }

    public static String getBrowserStackLog(String url) {
        return given()
                .baseUri(url)
                .auth().basic(PROP.getBrowserStackUser(), PROP.getBrowserStackPassword())
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().asString();
    }
}
