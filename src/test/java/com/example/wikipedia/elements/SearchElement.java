package com.example.wikipedia.elements;

public class SearchElement extends InputElement {
    private static final String SELECTOR = "input[placeholder='Искать в Википедии']";

    public SearchElement() {
        super(SELECTOR);
    }

    public void search(String query) {
        element.setValue(query).pressEnter();
    }
}