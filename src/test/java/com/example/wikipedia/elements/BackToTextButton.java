package com.example.wikipedia.elements;

public class BackToTextButton extends ClickableElement {
    private static final String BACK_BUTTON_XPATH = "//a[@title='Обратно к тексту']";

    public BackToTextButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static BackToTextButton byDefault() {
        return new BackToTextButton(BACK_BUTTON_XPATH, true);
    }
}
