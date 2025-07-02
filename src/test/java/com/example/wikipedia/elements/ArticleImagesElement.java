package com.example.wikipedia.elements;

import static com.codeborne.selenide.Selenide.$$;

public class ArticleImagesElement extends BaseElement {
    
    public ArticleImagesElement() {
        super("img");
    }
    
    public boolean hasImages() {
        return $$(".infobox img, .thumbimage").size() >= 1;
    }
    
    public int getImagesCount() {
        return $$(".infobox img, .thumbimage").size();
    }
}