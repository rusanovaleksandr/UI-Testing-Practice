package com.example.wikipedia.elements;

public class InfoboxImage extends ClickableElement {
    public InfoboxImage(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static InfoboxImage bySelector(String css_selector){
        return new InfoboxImage(css_selector, false);
    }
}
