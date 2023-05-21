package com.andersenlab.people.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.andersenlab.people.config.PropertiesConfig.PROP;
import static com.andersenlab.people.helpers.Attach.*;
import static com.andersenlab.people.spec.Specification.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseConfig {
    @BeforeAll
    public static void addConfig(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = PROP.getBaseUrl();
        Configuration.browserSize = PROP.getBrowserSize();
        Configuration.browser = PROP.getBrowserName();
        Configuration.pageLoadStrategy = PROP.getPageLoadStrategy();
        Configuration.headless = PROP.isHeadless();
        initSpecification(requestSpecification, responseSpecification);

        if (PROP.isRemote()) {
            Configuration.remote = PROP.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }





    @AfterEach
    public void tearDown() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();

        if (PROP.isRemote()) {
            addVideo();
        }

        closeWebDriver();
    }
}
