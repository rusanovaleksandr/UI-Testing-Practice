package com.example.wikipedia.elements;

public class ArticleTitleElement extends BaseElement {
    public ArticleTitleElement() {
        super("#firstHeading");
    }

    public String getText() {
        return element.getText();
    }
}