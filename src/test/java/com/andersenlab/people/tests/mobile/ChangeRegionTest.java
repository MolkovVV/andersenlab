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
@Story("Выбор региона")
@Tags({@Tag("ChangeRegion"), @Tag("Mobile"), @Tag("Ozon"), @Tag("ALL")})
public class ChangeRegionTest extends BaseMobileTest{
    @Test
    @DisplayName("Изменение региона доставки")
    @Severity(BLOCKER)
    public void changeRegion() {
        String region = "Москва";

        new MainPage()
                .changeRegion(region)
                .checkActualRegion(region);
    }
}
