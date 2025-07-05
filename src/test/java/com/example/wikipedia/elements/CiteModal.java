package com.example.wikipedia.elements;

import java.util.List;

public class CiteModal extends BaseElement {
    public CiteModal() {
        super("#mw-cite-modal");
    }

    public boolean isVisible() {
        return isDisplayed();
    }

    public boolean hasCitationFormat(String formatName) {
        List<String> formats = element.$$(".mw-cite-tab").texts();
        return formats.contains(formatName);
    }

    public boolean hasCitationContent() {
        return !element.$(".mw-cite-output").getText().isEmpty();
    }
}