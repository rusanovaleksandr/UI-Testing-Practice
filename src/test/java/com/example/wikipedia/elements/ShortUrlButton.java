package com.example.wikipedia.elements;

import static com.codeborne.selenide.Selenide.$;

import com.example.wikipedia.core.BaseElement;

public class ShortUrlButton extends BaseElement {
    public ShortUrlButton() {
        super("#t-urlshortener");
    }
    
    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
    }
    
    public void clickAndOpenDialog() {
        element.click();
    }

    public String getShortUrlFromDialog() {
        return $(".oo-ui-inputWidget-input").getAttribute("value");
    }
}