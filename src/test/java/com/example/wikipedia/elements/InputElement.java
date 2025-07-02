package com.example.wikipedia.elements;

public class InputElement extends BaseElement {
    public InputElement(String selector) {
        super(selector);
    }

    public void setValue(String text) {
        element.setValue(text);
    }

    public void clear() {
        element.clear();
    }
}