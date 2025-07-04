package com.example.wikipedia.elements;

public class InteractiveElement extends ClickableElement {
    public InteractiveElement(String selector) {
        super(selector);
    }

    public InteractiveElement(String locator, boolean isXpath) {
        super(locator, isXpath);
    }

    public static InteractiveElement byId(String id) {
        return new InteractiveElement(String.format(ID_XPATH, id), true);
    }

    public static InteractiveElement byType(String type) {
        return new InteractiveElement(String.format(TYPE_XPATH, type), true);
    }

    public static InteractiveElement byTitle(String title) {
        return new InteractiveElement(String.format(TITLE_XPATH, title), true);
    }

    public static InteractiveElement byName(String name) {
        return new InteractiveElement(String.format(NAME_XPATH, name), true);
    }

    public static InteractiveElement bySelector(String css_selector){
        return new InteractiveElement(css_selector, false);
    }
}
