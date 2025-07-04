package com.example.wikipedia.elements;

public class PasswordField extends InputElement{
    private static final String NAME_XPATH = "//*[@name='%s']";

    public PasswordField(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static PasswordField byId(String id){
        return new PasswordField(String.format(ID_XPATH, id), true); 
    }

    public static PasswordField byName(String name){
        return new PasswordField(String.format(NAME_XPATH, name), true); 
    }
}
