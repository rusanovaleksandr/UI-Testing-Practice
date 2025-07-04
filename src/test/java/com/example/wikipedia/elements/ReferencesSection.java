package com.example.wikipedia.elements;

public class ReferencesSection extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String DEFAULT_CSS_SELECTOR = "#Ссылки";

    public ReferencesSection(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static ReferencesSection byId(String id){
        return new ReferencesSection(String.format(ID_XPATH, id), true); 
    }
    
    public int getReferencesCount() {
        return element.$$x("./following-sibling::div[1]//li").size();
    }

    public static ReferencesSection byDefault() {
        return new ReferencesSection(DEFAULT_CSS_SELECTOR, false);
    }
}