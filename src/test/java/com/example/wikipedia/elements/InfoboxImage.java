package com.example.wikipedia.elements;

public class InfoboxImage extends BaseElement {
    private static final String IMG_BY_CLASS_XPATH = "//*[contains(@class, '%s')]/span/span[1]/a/img";

    public InfoboxImage(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public static InfoboxImage byParentClass(String class_name){
        return new InfoboxImage(String.format(IMG_BY_CLASS_XPATH, class_name), true);
    }
}
