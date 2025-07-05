package com.example.wikipedia.pages;

import com.example.wikipedia.elements.CitationHeading;

public class CitationPage extends BasePage {
    private final CitationHeading citationHeading = CitationHeading.byDefault();

    public CitationPage() {
        super();
    }

    public String getCitationHeadingText() {
        return citationHeading.getText();
    }
}