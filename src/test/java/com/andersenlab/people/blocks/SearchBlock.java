package com.andersenlab.people.blocks;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class SearchBlock {
    private final SelenideElement SEARCH_INPUT = $("input.SearchInput_searchInput___OgEl");

    public void searchVacancy(String vacancy){
        SEARCH_INPUT.sendKeys(vacancy + Keys.ENTER);
    }
}
