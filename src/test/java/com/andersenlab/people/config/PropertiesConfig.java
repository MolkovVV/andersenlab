package com.andersenlab.people.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import static org.aeonbits.owner.Config.*;


public class PropertiesConfig {

    public static final PropertiesInterface PROP = ConfigFactory.create(PropInterfaceTest.class, System.getProperties());

    @LoadPolicy(LoadType.MERGE)
    @Config.Sources({
            "system:properties",
            "classpath:${env}.properties",
            "file:~/${env}.properties",
            "file:./${env}.properties"
    })
    interface PropInterfaceTest extends PropertiesConfig.PropertiesInterface {
    }

    public interface PropertiesInterface extends Config {
        @DefaultValue("chrome")
        @Key("webBrowserName")
        String getBrowserName();

        @Key("webBrowserVersion")
        String getBrowserVersion();

        @Key("webBaseUrl")
        String getBaseUrl();

        @Key("apiBaseUrl")
        String getApiBaseUrl();

        @Key("webBrowserSize")
        String getBrowserSize();

        @Key("pageLoadStrategy")
        @DefaultValue("normal")
        String getPageLoadStrategy();

        @Key("webIsRemote")
        Boolean isRemote();

        @Key("webRemoteUrl")
        String getRemoteUrl();

        @Key("webIsHeadless")
        Boolean isHeadless();

        // Mobile tests properties
        @Key("browserstack.user")
        String getBrowserStackUser();

        @Key("browserstack.password")
        String getBrowserStackPassword();

        @Key("androidVersion")
        String getAndroidVersion();

        @Key("androidDevice")
        String getAndroidDevice();

        @Key("androidApp")
        String getAndroidApp();

        @Key("buildName")
        String getBuildName();
    }
}
