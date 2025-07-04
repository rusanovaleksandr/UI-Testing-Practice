package com.example.wikipedia.elements;

public class LanguageSwitchButton extends BaseElement {
    private static final String LANG_XPATH = "//*[@lang='%s']";

    public LanguageSwitchButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static LanguageSwitchButton byLangValue(String lang_value) {
        return new LanguageSwitchButton(String.format(LANG_XPATH, lang_value), true);
    }
}