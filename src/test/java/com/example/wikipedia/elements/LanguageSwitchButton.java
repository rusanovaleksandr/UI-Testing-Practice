package com.example.wikipedia.elements;

public class LanguageSwitchButton extends BaseElement {
    public LanguageSwitchButton() {
        super("a.interlanguage-link-target[lang='en']");
    }
    
    public boolean exists() {
        return element.exists();
    }
}