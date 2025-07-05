package com.example.wikipedia.elements;

public class FootnoteElement extends ClickableElement {
    private static final String FOOTNOTE_XPATH =
            "//sup[@class='reference']/a[contains(@href, 'cite_note') and contains(text(), '%s')]";

    public FootnoteElement(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static FootnoteElement byFootnoteNumber(String number) {
        String xpath = String.format(FOOTNOTE_XPATH, number);
        return new FootnoteElement(xpath, true);
    }
}
