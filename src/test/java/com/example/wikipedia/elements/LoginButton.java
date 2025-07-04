package com.example.wikipedia.elements;

public class LoginButton extends ClickableElement {
    public LoginButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static LoginButton byId(String id){
        return new LoginButton(String.format(ID_XPATH, id), true);
    }
}