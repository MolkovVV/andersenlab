package com.andersenlab.people.pages;

import com.andersenlab.people.blocks.HeroBlock;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TraineeshipPage extends Page {
    private final SelenideElement TITLE = $("h1.Title_title__mv7GI");
    private final HeroBlock heroBlock = new HeroBlock();
    private final String MAIN_TITLE = "Take the first step towards your career in IT with real professionals!";

    @Override
    @Step("Открыть страницу \"Traineeship\"")
    public TraineeshipPage open() {
        Selenide.open("/trainee");
        Selenide.executeJavaScript("document.querySelector('.CookiesPolicy_wrapper__3Navj').remove();");
        return this;
    }

    @Override
    @Step("Провалидировать заголовок на странице \"Traineeship\"")
    public TraineeshipPage validateMainTitle() {
        TITLE.shouldHave(Condition.visible);
        TITLE.shouldHave(text(MAIN_TITLE));
        return this;
    }

    @Override
    public String getMainTitle() {
        return MAIN_TITLE;
    }

    @Step("Провреить что в слайдере на странице \"Traineeship\" отображается фотография автора цитаты")
    public TraineeshipPage checkImageVisibilityInHeroBlock(){
        heroBlock.checkImageVisibility();
        return this;
    }

    @Step("Провреить что в слайдере на странице \"Traineeship\" отображается текст цитаты: \"{expectedText}\"")
    public TraineeshipPage checkQuoteTextInHeroBlock(String expectedText){
        heroBlock.checkQuoteText(expectedText);
        return this;
    }

    @Step("Провреить что в слайдере на странице \"Traineeship\" отображается имя автора цитаты: \"{expectedName}\"")
    public TraineeshipPage checkQuoteNameInHeroBlock(String expectedName){
        heroBlock.checkQuoteName(expectedName);
        return this;
    }
}
