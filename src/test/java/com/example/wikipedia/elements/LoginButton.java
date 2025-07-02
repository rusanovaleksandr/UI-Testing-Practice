package com.example.wikipedia.elements;

public class LoginButton extends BaseElement {
    private static final String DEFAULT_SELECTOR = "#pt-login";

    public LoginButton(String selector) {
        super(selector);
    }

    public static LoginButton byDefault() {
        return new LoginButton(DEFAULT_SELECTOR);
    }
}