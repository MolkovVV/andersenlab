package com.andersenlab.people.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class FormApplicant {
    private final SelenideElement INPUT_NAME = $("input[name=\"name\"]");
    private final SelenideElement INPUT_EMAIL = $("input[name=\"email\"]");
    private final SelenideElement INPUT_COMMENT = $("textarea[name=\"message\"]");
    private final SelenideElement INPUT_ATTACH = $("input[name=\"file\"]");
    private final SelenideElement SEND_BUTTON = $(".Button_button__aJej9");
    private final ElementsCollection ERRORS_FORM = $$(".FormError_title__j1W1M");

    public void fillAndSendForm(String name, String email, String comment,String fileName){
        INPUT_NAME.scrollTo().sendKeys(name);
        INPUT_EMAIL.sendKeys(email);
        INPUT_COMMENT.sendKeys(comment);
        INPUT_ATTACH.uploadFromClasspath(fileName);
    }

    public void checkErrorsInForm(){
        Assertions.assertTrue(ERRORS_FORM.asFixedIterable().stream().anyMatch(element -> element.getText() != null),"no text description errors in form");
    }
}
