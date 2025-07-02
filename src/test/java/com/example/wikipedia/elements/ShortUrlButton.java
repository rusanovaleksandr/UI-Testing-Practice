package com.example.wikipedia.elements;

import static com.codeborne.selenide.Selenide.$;

public class ShortUrlButton extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#t-urlshortener";

    public ShortUrlButton(String selector) {
        super(selector);
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

    public static ShortUrlButton byDefault() {
        return new ShortUrlButton(DEFAULT_CSS_SELECTOR);
    }
}