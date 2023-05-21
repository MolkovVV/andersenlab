package com.andersenlab.people.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.andersenlab.people.helpers.MobileHelper.checkPopUp;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ItemPage implements ISections, ISearch{
    private final String basketButton = "ru.ozon.app.android:id/mainBtn";

    public ItemPage() {
        checkPopUp();
        $(AppiumBy.id("ru.ozon.app.android:id/imageIv")).shouldBe(visible);
        $(AppiumBy.id(basketButton)).shouldBe(visible);
    }

    @Step("Добавить товар в корзину")
    public ItemPage addItemToBasket() {
        $(AppiumBy.id(basketButton)).click();
        return this;
    }
}
