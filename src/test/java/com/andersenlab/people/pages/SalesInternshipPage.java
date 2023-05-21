package com.andersenlab.people.pages;

import com.andersenlab.people.blocks.HeroBlock;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SalesInternshipPage extends Page {
    private final SelenideElement TITLE = $("h1.Title_title__mv7GI");
    private final HeroBlock heroBlock = new HeroBlock();
    private final String MAIN_TITLE = "Sales Traineeship to Take Your Next Career Step";

    @Override
    @Step("Открыть страницу \"Sales Internship\"")
    public SalesInternshipPage open() {
        Selenide.open("/sales-traineeship-program");
        Selenide.executeJavaScript("document.querySelector('.CookiesPolicy_wrapper__3Navj').remove();");
        return this;
    }

    @Override
    @Step("Провалидировать заголовок на странице \"Sales Internship\"")
    public SalesInternshipPage validateMainTitle() {
        TITLE.shouldHave(Condition.visible);
        TITLE.shouldHave(text(MAIN_TITLE));
        return this;
    }

    @Override
    public String getMainTitle() {
        return MAIN_TITLE;
    }

    @Step("Провреить что в слайдере на странице \"Sales Internship\" отображается фотография автора цитаты")
    public SalesInternshipPage checkImageVisibilityInHeroBlock(){
        heroBlock.checkImageVisibility();
        return this;
    }

    @Step("Провреить что в слайдере на странице \"Sales Internship\" отображается текст цитаты: \"{expectedText}\"")
    public SalesInternshipPage checkQuoteTextInHeroBlock(String expectedText){
        heroBlock.checkQuoteText(expectedText);
        return this;
    }

    @Step("Провреить что в слайдере на странице \"Sales Internship\" отображается имя автора цитаты: \"{expectedName}\"")
    public SalesInternshipPage checkQuoteNameInHeroBlock(String expectedName){
        heroBlock.checkQuoteName(expectedName);
        return this;
    }
}
