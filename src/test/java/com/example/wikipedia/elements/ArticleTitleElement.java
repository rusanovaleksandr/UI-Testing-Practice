package com.example.wikipedia.elements;

public class ArticleTitleElement extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#firstHeading";

    public ArticleTitleElement(String selector) {
        super(selector);
    }

    public static ArticleTitleElement byDefault(){
        return new ArticleTitleElement(DEFAULT_CSS_SELECTOR);
    }

    public String getText() {
        return element.getText();
    }
}