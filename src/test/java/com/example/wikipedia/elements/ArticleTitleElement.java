package com.example.wikipedia.elements;

import com.example.wikipedia.core.BaseElement;


public class ArticleTitleElement extends BaseElement {
    public ArticleTitleElement() {
        super("#firstHeading");
    }

    public String getText() {
        return element.getText();
    }
}