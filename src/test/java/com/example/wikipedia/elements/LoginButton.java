package com.example.wikipedia.elements;

public class LoginButton extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String DEFAULT_SELECTOR = "#pt-login";

    public LoginButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static LoginButton byId(String id){
        return new LoginButton(String.format(ID_XPATH, id), true);     }


    public static LoginButton byDefault() {
        return new LoginButton(DEFAULT_SELECTOR, false);
    }
}