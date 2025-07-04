package com.example.wikipedia.elements;

public class NotesSection extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String DEFAULT_CSS_SELECTOR = "#Примечания";

    public NotesSection(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static NotesSection byId(String id){
        return new NotesSection(String.format(ID_XPATH, id), true); 
    }
    
    public static NotesSection byDefault() {
        return new NotesSection(DEFAULT_CSS_SELECTOR, false);
    }
}