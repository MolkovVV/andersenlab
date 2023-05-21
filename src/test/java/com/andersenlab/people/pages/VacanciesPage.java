package com.andersenlab.people.pages;

import com.andersenlab.people.pages.interfaces.Searchable;
import com.andersenlab.people.blocks.SearchBlock;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class VacanciesPage extends Page implements Searchable {

private final SelenideElement TITLE = $("h1.Title_title__mv7GI");
private final SearchBlock SEARCH_BLOCK = new SearchBlock();
private final ElementsCollection SEARCH_RESULTS = $$("h3.VacancyCard_title__fo8bN");
private final ElementsCollection VACANCIES_CARDS = $$("a.VacancyCards_card__vMQTI");
private final String MAIN_TITLE = "Vacancies at Andersen";

    @Step("Найти вакансии по ключевому слову: \"{vacancy}\"")
    @Override
    public VacanciesPage searchVacancy(String vacancy) {
        SEARCH_BLOCK.searchVacancy(vacancy);
        return this;
    }

    @Step("Провалидировать что в наименовании вакансии присутствует слово: \"{expectedResult}\"  на странице \"Vacancies\"")
    public VacanciesPage validateSearchResults(String expectedResult) {
        Assertions.assertTrue(SEARCH_RESULTS.asFixedIterable().stream().allMatch(element -> element.getText().equals(expectedResult)));
        return this;
    }

    @Step("Открыть страницу \"Vacancies\"")
    @Override
    public VacanciesPage open() {
        Selenide.open("/vacancies");
        Selenide.executeJavaScript("document.querySelector('.CookiesPolicy_wrapper__3Navj').remove();");
        return this;
    }

    @Step("Провалидировать заголовок на странице \"Vacancies\"")
    @Override
    public VacanciesPage validateMainTitle() {
        TITLE.shouldHave(Condition.visible);
        TITLE.shouldHave(text(MAIN_TITLE));
        return this;
    }

    @Override
    public String getMainTitle() {
        return MAIN_TITLE;
    }

    @Step("Кликнуть на последнуюю карточку вакансии на текущей странице")
    public VacancyPage clickOnLastVacancyInList(){
        VACANCIES_CARDS.last().scrollTo().click();
        return new VacancyPage();
    }
}
