package com.andersenlab.people.tests.mobile;

import com.andersenlab.people.helpers.browserstack.models.BrowserStackSessionInfo;
import com.andersenlab.people.mobile.driver.BrowserStackAndroidDriver;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.andersenlab.people.helpers.Attach.*;
import static com.andersenlab.people.helpers.browserstack.BrowserStackHelper.getSessionInfo;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class BaseMobileTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserStackAndroidDriver.class.getName();
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = null;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    void openBrowser() {
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        screenshotAs("Last screenshot");
        pageSource();
        closeWebDriver();
        BrowserStackSessionInfo sessionInfo = getSessionInfo(sessionId);
            getBrowserStackVideo(sessionInfo);
            logs(sessionInfo);
            privateLink(sessionInfo);
            publicLink(sessionInfo);
    }
}
