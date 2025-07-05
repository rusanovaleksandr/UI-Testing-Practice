package com.example.wikipedia.elements;

public abstract class ScrollableElement extends BaseElement {
    public ScrollableElement(String selector) {
        super(selector);
    }

    public void scrollTo() {
        element.scrollTo();
    }
}