package com.andersenlab.people.pages;

import com.andersenlab.people.blocks.FormApplicant;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VacancyPage extends Page{
    private final SelenideElement TITLE = $("h2.Title_title__mv7GI");
    private String idVacancy;
    private final FormApplicant FORM_APPLICANT = new FormApplicant();
    private final String MAIN_TITLE ="Summary";

    public VacancyPage(String idVacancy) {
        this.idVacancy = idVacancy;
    }

    public VacancyPage() {
    }

    public void setIdVacancy(String idVacancy) {
        this.idVacancy = idVacancy;
    }

    @Override
    @Step("Открыть страницу \"Vacancy\"")
    public VacancyPage open() {
        Selenide.open("vacancy/"+ idVacancy);
        Selenide.executeJavaScript("document.querySelector('.CookiesPolicy_wrapper__3Navj').remove();");
        return this;
    }

    @Override
    @Step("Провалидировать заголовок на странице \"Vacancy\"")
    public VacancyPage validateMainTitle () {
        TITLE.shouldHave(Condition.visible);
        TITLE.shouldHave(text(MAIN_TITLE));
        return this;
    }

    @Override
    public String getMainTitle() {
        return MAIN_TITLE;
    }

    @Step("Заполнить формы соискателя на странице \"Vacancy\" значениями email:\"{email}\", name:\"{name}\", comment:\"{comment}\"")
    public VacancyPage fillApplicantFormAndSent(String name, String email, String comment,String fileName){
        FORM_APPLICANT.fillAndSendForm(name,email,comment,fileName);
        return this;
    }

    @Step("Проверить что в форме соискателя на странице \"Vacancy\" отображаются ошибки при некорректном заполнении")
    public VacancyPage checkErrorsInForm(){
        FORM_APPLICANT.checkErrorsInForm();
        return this;
    }
}
