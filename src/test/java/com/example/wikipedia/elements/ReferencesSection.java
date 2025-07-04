package com.example.wikipedia.elements;

public class ReferencesSection extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";

    public ReferencesSection(String selector, boolean xpath) {
        super(selector, xpath);
    }
    
    public int getReferencesCount() {
        return element.$$x("./following-sibling::div[1]//li").size();
    }

    public static ReferencesSection byId(String id){
        return new ReferencesSection(String.format(ID_XPATH, id), true); 
    }

}