package com.andersenlab.people.tests.web;

import com.andersenlab.people.tests.BaseTest;
import com.andersenlab.people.pages.MainPage;
import com.andersenlab.people.pages.Page;
import com.andersenlab.people.pages.SalesInternshipPage;
import com.andersenlab.people.pages.TraineeshipPage;
import com.andersenlab.people.testdata.FakeTestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class WebTests extends BaseTest {

    @Test
    @Tags({
            @Tag("WEB"),
            @Tag("Regress")
    })
    @Feature("Навигация -> Header-menu")
    @DisplayName("Проверка перхода по элементам главного меню")
    @Severity(SeverityLevel.CRITICAL)
    public void clickMainMenuElements() {
        Page page = new MainPage();
        page.open().validateMainTitle()
                .clickHeaderMenuSalesInternshipElement().validateMainTitle()
                .clickHeaderMenuTraineeshipElement().validateMainTitle()
                .clickHeaderMenuVacanciesElement().validateMainTitle()
                .clickHeaderLogo().validateMainTitle();
    }

    @Test
    @Tags({
            @Tag("WEB"),
            @Tag("Regress")
    })
    @Feature("Поиск вакансий")
    @DisplayName("Поиск вакансии при отправке запроса с главной страницы")
    @Severity(SeverityLevel.CRITICAL)
    public void searchVacancyFromMainPage() {
        FakeTestData data = new FakeTestData();
        MainPage page = new MainPage();

        page.open()
                .searchVacancy(data.jobName)
                .validateSearchResults(data.jobName);
    }

    @Test
    @Tags({
            @Tag("WEB"),
            @Tag("Regress")
    })
    @DisplayName("Проверка отображения текстовых ошибок при некорректном заполнении формы соискателя")
    public void failSendFormVacancy() {
        FakeTestData data = new FakeTestData();
        MainPage page = new MainPage();

        page.open()
                .searchVacancy("Java Developer")
                .clickOnLastVacancyInList()
                .validateMainTitle()
                .fillApplicantFormAndSent(data.name, data.email, data.comment, data.fileName)
                .checkErrorsInForm();
    }

    @Tags({
            @Tag("WEB"),
            @Tag("Regress")
    })
    @DisplayName("Проверка слайдера")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest(name = "на странице {0}")
    @MethodSource("generateDataCheckSliderArea")

    public void checkSliderArea(Page incomingParam, String name, String expectedText) {
        if (incomingParam instanceof MainPage){
            MainPage mainPage = (MainPage) incomingParam;
            mainPage.open()
                    .checkImageVisibilityInHeroBlock()
                    .checkQuoteTextInHeroBlock(expectedText)
                    .checkQuoteNameInHeroBlock(name);
        }

        if (incomingParam instanceof TraineeshipPage){
            TraineeshipPage traineeshipPage = (TraineeshipPage) incomingParam;
            traineeshipPage.open()
                    .checkImageVisibilityInHeroBlock()
                    .checkQuoteNameInHeroBlock(name)
                    .checkQuoteTextInHeroBlock(expectedText);
        }

        if (incomingParam instanceof SalesInternshipPage){
            SalesInternshipPage salesInternshipPage = (SalesInternshipPage) incomingParam;
            salesInternshipPage.open()
                    .checkImageVisibilityInHeroBlock()
                    .checkQuoteNameInHeroBlock(name)
                    .checkQuoteTextInHeroBlock(expectedText);
        }
    }
    private static Stream<Arguments> generateDataCheckSliderArea() {
        return Stream.of(
                Arguments.of(new MainPage(),"Vasili Fedzkin (24 years old)","After joining Andersen, I saw straight away that it's a world-class team. Everything is at a high level here: projects, tech stack, and, of course, working conditions!"),
                Arguments.of(new TraineeshipPage(),"Ilya Matantsev (28 years old)","Andersen offers excellent career opportunities. Here, you can find everything you need for growth: interesting projects and a strong team!"),
                Arguments.of(new SalesInternshipPage(),"Valentin Kuzmenko","Valentin is the Head of our Commercial Department with a remarkable track record. His belief is that only practice makes perfect and hard work rewards."));
    }
}
