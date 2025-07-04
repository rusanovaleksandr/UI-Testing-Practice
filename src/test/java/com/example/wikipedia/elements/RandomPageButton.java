package com.example.wikipedia.elements;

public class RandomPageButton extends BaseElement {
    private static final String ID_XPATH = "//*[@id='%s']";
    private static final String TITLE_XPATH = "//*[contains(@title, '%s')]";

    public RandomPageButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static RandomPageButton byId(String id){
        return new RandomPageButton(String.format(ID_XPATH, id), true);
    }

    public static RandomPageButton byTitle(String title){
        return new RandomPageButton(String.format(TITLE_XPATH, title), true);
    }
}