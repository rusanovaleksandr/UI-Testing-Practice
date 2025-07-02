package com.example.wikipedia.elements;

public class LoginField extends BaseElement{
    private static final String DEFAULT_SELECTOR = "#wpName1";

    public LoginField(String selector) {
        super(selector);
    }

    public void setValue(String value){
        element.setValue(value);
    }

    public static LoginField byDefault() {
        return new LoginField(DEFAULT_SELECTOR);
    }
}