package com.example.wikipedia.elements;

public class CiteButton extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#t-cite";

    public CiteButton(String selector) {
        super(selector);
    }

    public static CiteButton byDefault(){
        return new CiteButton(DEFAULT_CSS_SELECTOR);
    }

    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
    }

    public void click() {
        element.click();
    }
}