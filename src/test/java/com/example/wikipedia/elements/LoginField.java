package com.example.wikipedia.elements;

public class LoginField extends InputElement{
    private static final String NAME_XPATH = "//*[@name='%s']";

    public LoginField(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static LoginField byId(String id){
        return new LoginField(String.format(ID_XPATH, id), true); 
    }

    public static LoginField byName(String name){
        return new LoginField(String.format(NAME_XPATH, name), true); 
    }
}