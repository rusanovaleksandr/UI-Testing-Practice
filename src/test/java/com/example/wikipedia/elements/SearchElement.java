package com.example.wikipedia.elements;

public class SearchElement extends InputElement {
    public SearchElement(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public void search(String query) {
        element.setValue(query).pressEnter();
    }

    public static SearchElement byClass(String class_name){
        return new SearchElement(String.format(CLASS_XPATH, class_name), true);
    }
}