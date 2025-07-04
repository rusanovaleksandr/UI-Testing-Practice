package com.example.wikipedia.elements;

public class PasswordField extends BaseElement{
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String NAME_XPATH = "//*[@name='%s']";
    private static final String DEFAULT_SELECTOR = "#wpPassword1";

    public PasswordField(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public void setValue(String value){
        element.setValue(value);
    }

    public static PasswordField byId(String id){
        return new PasswordField(String.format(ID_XPATH, id), true); 
    }

    public static PasswordField byName(String name){
        return new PasswordField(String.format(NAME_XPATH, name), true); 
    }

    public static PasswordField byDefault() {
        return new PasswordField(DEFAULT_SELECTOR, false);
    }
}
