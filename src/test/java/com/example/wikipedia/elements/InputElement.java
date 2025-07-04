package com.example.wikipedia.elements;

public class InputElement extends BaseElement {
    public InputElement(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public void fill(String text) {
        element.setValue(text);
    }

    public void clear() {
        element.clear();
    }
}