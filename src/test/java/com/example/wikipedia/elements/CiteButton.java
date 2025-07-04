package com.example.wikipedia.elements;

public class CiteButton extends ClickableElement {    
    public CiteButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static CiteButton byId(String id){
        return new CiteButton(String.format(ID_XPATH, id), true);
    }
}