package com.example.wikipedia.elements;

import com.codeborne.selenide.ElementsCollection;

public class ReferencesSection extends ScrollableElement {
    public static final String DEFAULT_SELECTOR = "#Ссылки";

    public ReferencesSection(String selector) {
        super(selector);
    }

    public void clickFirstLink() {
        element.$("a").click();
    }

    public boolean hasLinks() {
        ElementsCollection links = element.$$("a");
        return !links.isEmpty();
    }

    public static ReferencesSection byDefault() {
        return new ReferencesSection(DEFAULT_SELECTOR);
    }
}