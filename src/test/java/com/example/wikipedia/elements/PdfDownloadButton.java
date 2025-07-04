package com.example.wikipedia.elements;

public class PdfDownloadButton extends BaseElement {
    private static final String ID_XPATH = "//*[@id=\"%s\"]";

    public PdfDownloadButton(String selector, boolean xpath) {
        super(selector, xpath);
    }
    

    public static PdfDownloadButton byId(String id){
        return new PdfDownloadButton(String.format(ID_XPATH, id), true);
    }
}