package com.andersenlab.people.blocks;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HeroBlock {
    private final SelenideElement HERO_IMAGE = $(".HeroBlock_image__a30A_");
    private final ElementsCollection BLOCK_QUOTES = $$("p.Blockquote_quote__XrC3d");
    private final ElementsCollection BLOCK_QUOTE_NAMES = $$("p.Blockquote_name__NZh4i");
    private final ElementsCollection SLIDER_BUTTONS = $$(".heroSlider [aria-label=\"Slider button\"]");

    public void checkImageVisibility(){
        HERO_IMAGE.shouldBe(visible);
    }

    public void checkQuoteText(String expectedText){
        Assertions.assertTrue(BLOCK_QUOTES.texts().stream().anyMatch(elem->elem.equals(expectedText)));
    }

    public void checkQuoteName(String expectedName){
        Assertions.assertTrue(BLOCK_QUOTE_NAMES.texts().stream().anyMatch(elem->elem.equals(expectedName)));
    }

    public void clickNextSliderButton(){
        SLIDER_BUTTONS.last().click();
    }

    public void clickPreSliderButton(){
        SLIDER_BUTTONS.first().click();
    }
}
