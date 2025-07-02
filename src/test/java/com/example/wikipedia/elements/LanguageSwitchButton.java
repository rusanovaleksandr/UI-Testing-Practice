package com.example.wikipedia.elements;

import com.example.wikipedia.core.BaseElement;

public class LanguageSwitchButton extends BaseElement {
    public LanguageSwitchButton() {
        super("a.interlanguage-link-target[lang='en']");
    }
    
    public boolean exists() {
        return element.exists();
    }
}