package com.andersenlab.people.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.andersenlab.people.config.PropertiesConfig.PROP;
import static com.andersenlab.people.helpers.Attach.*;

public class BaseTest {
    @BeforeAll
    public static void addConfig(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = PROP.getBaseUrl();
        Configuration.browserSize = PROP.getBrowserSize();
        Configuration.browserVersion = PROP.getBrowserVersion();
        Configuration.browser = PROP.getBrowserName();
        Configuration.pageLoadStrategy = PROP.getPageLoadStrategy();
        Configuration.headless = PROP.isHeadless();


        if (PROP.isRemote()) {
            Configuration.remote = PROP.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setAcceptInsecureCerts(false);
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
    }
}
