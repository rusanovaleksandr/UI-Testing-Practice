package com.example.wikipedia.elements;

import static com.codeborne.selenide.Condition.visible;

public class CitationHeading extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#firstHeading";

    public CitationHeading() {
        super(DEFAULT_CSS_SELECTOR);
    }

    public String getText() {
        return element.shouldBe(visible).getText();
    }

    public static CitationHeading byDefault(){
        return new CitationHeading();
    }    
}