package com.example.wikipedia.elements;

import com.example.wikipedia.core.BaseElement;

public class PdfDownloadButton extends BaseElement {
    public PdfDownloadButton() {
        super("#coll-download-as-rl");
    }
    
    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
    }
}