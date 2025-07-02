package com.example.wikipedia.elements;

import static com.codeborne.selenide.Selenide.$$;

public class ArticleImagesElement extends BaseElement {
    private static final String DEFAULT_CSS_SELECTOR = "img";

    public ArticleImagesElement(String selector) {
        super(selector);
    }
    
    public boolean hasImages() {
        return $$(".infobox img, .thumbimage").size() >= 1;
    }
    
    public int getImagesCount() {
        return $$(".infobox img, .thumbimage").size();
    }

    public static ArticleImagesElement byDefault(){
        return new ArticleImagesElement(DEFAULT_CSS_SELECTOR);
    }
}