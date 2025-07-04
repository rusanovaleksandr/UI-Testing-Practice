package com.example.wikipedia.elements;

public class SearchElement extends InputElement {
    private static final String CLASS_XPATH = "//*[@class='%s']";
    private static final String DEFAULT_CSS_SELECTOR = "input[placeholder='Искать в Википедии']";

    public SearchElement(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public void search(String query) {
        element.setValue(query).pressEnter();
    }

    public static SearchElement byClass(String class_name){
        return new SearchElement(String.format(CLASS_XPATH, class_name), true);
    }

    public static SearchElement byDefault() {
        return new SearchElement(DEFAULT_CSS_SELECTOR, false);
    }
}