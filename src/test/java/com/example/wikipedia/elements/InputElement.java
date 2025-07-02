package com.example.wikipedia.elements;

import com.example.wikipedia.core.BaseElement;

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