package com.example.wikipedia.elements;

public class NotesSection extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";

    public NotesSection(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static NotesSection byId(String id){
        return new NotesSection(String.format(ID_XPATH, id), true); 
    }
}