package com.example.wikipedia.elements;

public class LanguageSwitchButton extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "a.interlanguage-link-target[lang='en']";

    public LanguageSwitchButton(String selector) {
        super(selector);
    }
    
    public boolean exists() {
        return element.exists();
    }

    public static LanguageSwitchButton byDefault() {
        return new LanguageSwitchButton(DEFAULT_CSS_SELECTOR);
    }
}