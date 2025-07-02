package com.example.wikipedia.elements;

public class RandomPageButton extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#Примечания";

    public RandomPageButton(String selector) {
        super(selector);
    }

    public static RandomPageButton byDefault() {
        return new RandomPageButton(DEFAULT_CSS_SELECTOR);
    }
}