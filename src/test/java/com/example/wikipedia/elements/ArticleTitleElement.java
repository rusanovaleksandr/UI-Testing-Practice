package com.example.wikipedia.elements;

public class ArticleTitleElement extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String DEFAULT_ID = "firstHeading";

    public ArticleTitleElement(String selector, boolean xpath) {
        super(selector, xpath);
    }
    
    public String getText() {
            return element.getText();
        }

    public static ArticleTitleElement byId(String id){
        return new ArticleTitleElement(String.format(ID_XPATH, id), true);
    }

    public static ArticleTitleElement byDefault(){
        return new ArticleTitleElement(String.format("#%s", DEFAULT_ID), false);
    }
}