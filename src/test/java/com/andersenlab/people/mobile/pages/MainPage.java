package com.andersenlab.people.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.andersenlab.people.helpers.MobileHelper.checkPopUp;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.back;
import static io.appium.java_client.AppiumBy.id;

public class MainPage implements ISections, ISearch{

    private final String changeRegionButton = "ru.ozon.app.android:id/addressBookBarLl";
    private final String searchField = "ru.ozon.app.android:id/search_src_text";

    public MainPage() {
        checkPopUp();
        $(id(mainMenuButton)).shouldHave(attribute("selected", "true"));
    }

    @Step("Изменить регион на {regionName}")
    public MainPage changeRegion(String regionName) {
        $(AppiumBy.id(changeRegionButton)).click();
        $(byText("Куда доставить заказ?")).shouldBe(visible);
        $(AppiumBy.id(changeRegionButton)).click();
        $(AppiumBy.id(searchField)).click();
        $(AppiumBy.id(searchField)).setValue(regionName);
        back();
        $$(id("ru.ozon.app.android:id/locationFal"))
                .shouldHave(sizeGreaterThanOrEqual(2)).get(1).click();
        return new MainPage();
    }

    @Step("Убедиться, что текущий регион '{regionName}'")
    public MainPage checkActualRegion(String regionName) {
        $(AppiumBy.id("ru.ozon.app.android:id/titleTav")).shouldHave(text(regionName));
        return this;
    }
}
