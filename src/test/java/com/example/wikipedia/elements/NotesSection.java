package com.example.wikipedia.elements;

public class NotesSection extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#Примечания";

    public NotesSection(String selector) {
        super(selector);
    }
    
    public static NotesSection byDefault() {
        return new NotesSection(DEFAULT_CSS_SELECTOR);
    }
}