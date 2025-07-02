package com.example.wikipedia.elements;

public class LoginAttemptButton extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#wpLoginAttempt";
    
    public LoginAttemptButton(String selector) {
        super(selector);
    }

    public static LoginAttemptButton byDefault(){
        return new LoginAttemptButton(DEFAULT_CSS_SELECTOR);
    }
}
