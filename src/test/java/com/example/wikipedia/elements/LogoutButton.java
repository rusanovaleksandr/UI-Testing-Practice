package com.example.wikipedia.elements;

public class LogoutButton extends BaseElement {
    private static final String DEFAULT_SELECTOR = "#pt-logout";

    public LogoutButton(String selector) {
        super(selector);
    }

    public static LogoutButton byDefault() {
        return new LogoutButton(DEFAULT_SELECTOR);
    }
}
