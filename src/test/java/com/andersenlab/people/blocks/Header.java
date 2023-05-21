package com.andersenlab.people.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {
    private final SelenideElement LOGO = $("a.Header_logoWrap__NnYcc");
    private final ElementsCollection MENU_LINKS = $$("a.Header_link__trIMx");
    private final SelenideElement DROPDOWN_SUBMENU_LINK = $(".SubMenu_listItem__c6uXe");
    private final ElementsCollection DROPDOWN_SUBMENU_VISIBLE_SOCIALS = $$("a.SubMenuContent_socialButton__l1J4k");
    private final ElementsCollection DROPDOWN_SUBMENU_VISIBLE_CONTENT_LINKS = $$("a.SubMenuContent_link__Pe5Wq");

    public void clickLogo(){
        LOGO.click();
    }

    public void clickMenuElement(String textInElement){
        MENU_LINKS.findBy(text(textInElement)).click();
    }

    public void clickDropDownMenuElement(){
        DROPDOWN_SUBMENU_LINK.click();
    }

    public void clickSocialMediaInDropDownMenu(int numberElementInCollection){
        DROPDOWN_SUBMENU_VISIBLE_SOCIALS.get(numberElementInCollection).click();
    }

    public void clickDropDownSubMenuVisibleContentLink(String textInElement){
        DROPDOWN_SUBMENU_VISIBLE_CONTENT_LINKS.findBy(text(textInElement)).click();
    }
}
