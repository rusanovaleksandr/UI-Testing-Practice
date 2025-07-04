package com.example.wikipedia.elements;

import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;


public class GalleryCloseButton extends BaseElement {
    private static final int TIMEOUT = 3; 
    
    public GalleryCloseButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public void clickAndWaitUntilClosed() {
        element.shouldBe(visible, ofSeconds(TIMEOUT)).click();
    }

    public void waitUntilOpened() {
        element.shouldBe(visible, ofSeconds(TIMEOUT));
    }

    public static GalleryCloseButton byTitle(String title){
        return new GalleryCloseButton(String.format(TITLE_XPATH, title), true);
    }
}

