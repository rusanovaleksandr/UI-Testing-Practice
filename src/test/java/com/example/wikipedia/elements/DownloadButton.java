package com.example.wikipedia.elements;

public class DownloadButton extends BaseElement {
    private static final String TEXT_XPATH = "//button[.//span[text()='%s']]";

    public DownloadButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static DownloadButton byText(String id) {
        return new DownloadButton(String.format(TEXT_XPATH, id), true);
    }

}
