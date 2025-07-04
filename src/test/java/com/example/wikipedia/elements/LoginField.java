package com.example.wikipedia.elements;

public class LoginField extends BaseElement{
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String NAME_XPATH = "//*[@name='%s']";
    private static final String DEFAULT_SELECTOR = "#wpName1";

    public LoginField(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public void setValue(String value){
        element.setValue(value);
    }

    public static LoginField byId(String id){
        return new LoginField(String.format(ID_XPATH, id), true); 
    }

    public static LoginField byName(String name){
        return new LoginField(String.format(NAME_XPATH, name), true); 
    }

    public static LoginField byDefault() {
        return new LoginField(DEFAULT_SELECTOR, false);
    }
}