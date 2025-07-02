package com.example.wikipedia.elements;

public class PasswordField extends BaseElement{
    private static final String DEFAULT_SELECTOR = "#wpPassword1";

    public PasswordField(String selector) {
        super(selector);
    }

    public void setValue(String value){
        element.setValue(value);
    }

    public static PasswordField byDefault() {
        return new PasswordField(DEFAULT_SELECTOR);
    }
}
