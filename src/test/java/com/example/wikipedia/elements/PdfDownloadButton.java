package com.example.wikipedia.elements;

public class PdfDownloadButton extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "#coll-download-as-rl";

    public PdfDownloadButton(String selector) {
        super(selector);
    }
    
    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
    }

    public static PdfDownloadButton byDefault() {
        return new PdfDownloadButton(DEFAULT_CSS_SELECTOR);
    }
}