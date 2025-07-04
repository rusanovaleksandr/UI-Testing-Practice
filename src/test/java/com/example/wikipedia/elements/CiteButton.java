package com.example.wikipedia.elements;

public class CiteButton extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String DEFAULT_ID = "t-cite";
    
    public CiteButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
    }
    public static CiteButton byId(String id){
        return new CiteButton(String.format(ID_XPATH, id), true);
    }

    public static CiteButton byDefault(){
        return new CiteButton(String.format("#%s", DEFAULT_ID), false);
    }
}