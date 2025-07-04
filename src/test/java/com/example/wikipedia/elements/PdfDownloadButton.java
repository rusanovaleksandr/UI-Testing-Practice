package com.example.wikipedia.elements;

public class PdfDownloadButton extends BaseElement {
    private static final String ID_XPATH = "//*[@id=\"%s\"]";
    private static final String DEFAULT_CSS_SELECTOR = "#coll-download-as-rl";

    public PdfDownloadButton(String selector, boolean xpath) {
        super(selector, xpath);
    }
    
    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
    }

    public static PdfDownloadButton byId(String id){
        return new PdfDownloadButton(String.format(ID_XPATH, id), true);
    }

    public static PdfDownloadButton byDefault() {
        return new PdfDownloadButton(DEFAULT_CSS_SELECTOR, false);
    }
}