package com.andersenlab.people.pages;

import com.andersenlab.people.blocks.Header;
import io.qameta.allure.Step;

public abstract class Page {
    private Header header = new Header();

    @Step("Перейти на главную страницу по клику на логотип в Header")
    public MainPage clickHeaderLogo() {
        header.clickLogo();
        return new MainPage();
    }

    @Step("Перейти на страницу \"Вакансии\" по клику на соответствующий элемент в Header-menu")
    public VacanciesPage clickHeaderMenuVacanciesElement() {
        header.clickMenuElement("Vacancies");
        return new VacanciesPage();
    }

    @Step("Перейти на страницу \"Стажировка\" по клику на соответствующий элемент в Header-menu")
    public TraineeshipPage clickHeaderMenuTraineeshipElement() {
        header.clickMenuElement("Traineeship");
        return new TraineeshipPage();
    }

    @Step("Перейти на страницу \"Стажировка по продажам\" по клику на соответствующий элемент в Header-menu")
    public SalesInternshipPage clickHeaderMenuSalesInternshipElement() {
        header.clickMenuElement("Sales Internship");
        return new SalesInternshipPage();
    }

    @Step("Развернуть выпадающее меню \"Andersen Global\" по клику на соответствующий элемент в Header-menu")
    public Page clickHeaderDropDownMenuElement() {
        header.clickDropDownMenuElement();
        return this;
    }

    public abstract Page open();

    public abstract Page validateMainTitle();

    public abstract String getMainTitle();

}
