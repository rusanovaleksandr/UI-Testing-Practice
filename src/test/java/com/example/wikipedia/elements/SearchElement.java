package com.example.wikipedia.elements;

public class SearchElement extends InputElement {
    private static final String DEFAULT_CSS_SELECTOR = "input[placeholder='Искать в Википедии']";

    public SearchElement(String selector) {
        super(selector);
    }

    public void search(String query) {
        element.setValue(query).pressEnter();
    }

    public static SearchElement byDefault() {
        return new SearchElement(DEFAULT_CSS_SELECTOR);
    }
}