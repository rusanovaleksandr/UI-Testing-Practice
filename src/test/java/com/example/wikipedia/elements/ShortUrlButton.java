package com.example.wikipedia.elements;

import static com.codeborne.selenide.Selenide.$;

public class ShortUrlButton extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";

    public ShortUrlButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public void clickAndOpenDialog() {
        element.click();
    }

    public String getShortUrlFromDialog() {
        return $(".oo-ui-inputWidget-input").getAttribute("value");
    }

    public static ShortUrlButton byId(String id){
        return new ShortUrlButton(String.format(ID_XPATH, id), true);
    }
}