package com.andersenlab.people.blocks;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class IntoLayoutBlock {
    private final SelenideElement BUTTON = $("a.Button_button__aJej9");
    public void clickButton(){
        BUTTON.click();
    }
}
