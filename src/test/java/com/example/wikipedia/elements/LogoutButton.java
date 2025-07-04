package com.example.wikipedia.elements;

public class LogoutButton extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String DEFAULT_SELECTOR = "#pt-logout";

    public LogoutButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static LogoutButton byId(String id){
        return new LogoutButton(String.format(ID_XPATH, id), true); 
    }


    public static LogoutButton byDefault() {
        return new LogoutButton(DEFAULT_SELECTOR, false);
    }
}
