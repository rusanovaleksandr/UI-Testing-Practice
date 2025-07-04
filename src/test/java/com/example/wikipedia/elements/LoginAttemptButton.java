package com.example.wikipedia.elements;

public class LoginAttemptButton extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String TYPE_XPATH = "//*[@type='%s']";
    private static final String DEFAULT_CSS_SELECTOR = "#wpLoginAttempt";
    
    public LoginAttemptButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static LoginAttemptButton byId(String id){
        return new LoginAttemptButton(String.format(ID_XPATH, id), true); 
    }

    public static LoginAttemptButton byType(String type){
        return new LoginAttemptButton(String.format(TYPE_XPATH, type), true); 
    }

    public static LoginAttemptButton byDefault(){
        return new LoginAttemptButton(DEFAULT_CSS_SELECTOR, false);
    }
}
