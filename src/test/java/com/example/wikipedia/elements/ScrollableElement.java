package com.example.wikipedia.elements;

public abstract class ScrollableElement extends BaseElement {
    public ScrollableElement(String selector) {
        super(selector);
    }

    public ScrollableElement(String locator, boolean isXpath) {
        super(locator, isXpath);
    }

    public void scrollTo() {
        element.scrollTo();
    }
}