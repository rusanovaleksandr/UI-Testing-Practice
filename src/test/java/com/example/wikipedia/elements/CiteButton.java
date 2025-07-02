package com.example.wikipedia.elements;

public class CiteButton extends BaseElement {
    public CiteButton() {
        super("#t-cite");
    }
    
    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
    }
}