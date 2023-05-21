package com.andersenlab.people.tests.mobile;

import com.andersenlab.people.mobile.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Ozon")
@Story("Поиск")
@Tags({@Tag("Search"), @Tag("Mobile"), @Tag("Ozon")})
public class SearchTest extends BaseMobileTest {
    @Test
    @DisplayName("Поиск товара и добавление в корзину")
    @Severity(BLOCKER)
    public void searchAndAdd() {
        new MainPage()
                .changeRegion("Пенза")
                .search("nesquik какао")
                .checkResultsOfSearch()
                .openFirstItem();
    }
}
