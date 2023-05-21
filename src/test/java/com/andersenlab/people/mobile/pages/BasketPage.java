package com.andersenlab.people.mobile.pages;

import io.qameta.allure.Step;

import static com.andersenlab.people.helpers.MobileHelper.checkPopUp;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;

import static io.appium.java_client.AppiumBy.id;

public class BasketPage implements ISections{
    public BasketPage() {
        checkPopUp();
        $(id("ru.ozon.app.android:id/toolbarTb"))
                .$(byText("Корзина"))
                .shouldBe(visible);
    }

    @Step("Убедиться, что товар находится в корзине")
    public BasketPage checkItemExist() {
        $(id("ru.ozon.app.android:id/productsRV")).shouldBe(visible);
        return this;
    }
}
