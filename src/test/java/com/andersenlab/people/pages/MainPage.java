package com.andersenlab.people.pages;

import com.andersenlab.people.pages.interfaces.Searchable;
import com.andersenlab.people.blocks.HeroBlock;
import com.andersenlab.people.blocks.SearchBlock;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page implements Searchable {
    private final SearchBlock SEARCH_BLOCK = new SearchBlock();
    private final SelenideElement TITLE = $("h1.Title_title__mv7GI");
    private final HeroBlock heroBlock = new HeroBlock();
    private final String MAIN_TITLE = "The new direction of your IT career";

    @Step("Найти вакансии по ключевому слову: \"{vacancy}\"")
    @Override
    public VacanciesPage searchVacancy(String vacancy) {
        SEARCH_BLOCK.searchVacancy(vacancy);
        return new VacanciesPage();
    }

    @Step("Открыть главную страницу")
    @Override
    public MainPage open() {
        Selenide.open("/");
        Selenide.executeJavaScript("document.querySelector('.CookiesPolicy_wrapper__3Navj').remove();");
        return this;
    }

    @Step("Провалидировать заголовок на главной странице")
    @Override
    public MainPage validateMainTitle() {
        TITLE.shouldHave(Condition.visible);
        TITLE.shouldHave(text(MAIN_TITLE));
        return this;
    }

    @Override
    public String getMainTitle() {
        return MAIN_TITLE;
    }

    @Step("Провреить что в слайдере на главной странице отображается фотография автора цитаты")
    public MainPage checkImageVisibilityInHeroBlock(){
        heroBlock.checkImageVisibility();
        return this;
    }

    @Step("Провреить что в слайдере на главной странице отображается текст цитаты: \"{expectedText}\"")
    public MainPage checkQuoteTextInHeroBlock(String expectedText){
        heroBlock.checkQuoteText(expectedText);
        return this;
    }

    @Step("Провреить что в слайдере на главной странице отображается имя автора цитаты: \"{expectedName}\"")
    public MainPage checkQuoteNameInHeroBlock(String expectedName){
        heroBlock.checkQuoteName(expectedName);
        return this;
    }
}
