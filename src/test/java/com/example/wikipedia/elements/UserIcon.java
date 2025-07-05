package com.example.wikipedia.elements;

public class UserIcon extends InteractiveElement {
    public UserIcon(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public String getText()
    {
        return element.getText();
    }

    public static UserIcon byId(String id){
        return new UserIcon(String.format(ID_XPATH, id), true);
    }
}