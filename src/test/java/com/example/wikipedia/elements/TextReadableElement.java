package com.example.wikipedia.elements;

public class TextReadableElement extends InteractiveElement{
    public TextReadableElement(String selector) {
        super(selector);
    }

    public TextReadableElement(String locator, boolean isXpath) {
        super(locator, isXpath);
    }

    public String getText() {
        return element.getText();
    }
}
