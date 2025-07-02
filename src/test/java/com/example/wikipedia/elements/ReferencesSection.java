package com.example.wikipedia.elements;

public class ReferencesSection extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#Ссылки";

    public ReferencesSection(String selector) {
        super(selector);
    }

    public boolean exists() {
        return element.exists();
    }
    
    public int getReferencesCount() {
        return element.$$x("./following-sibling::div[1]//li").size();
    }

    public static ReferencesSection byDefault() {
        return new ReferencesSection(DEFAULT_CSS_SELECTOR);
    }
}