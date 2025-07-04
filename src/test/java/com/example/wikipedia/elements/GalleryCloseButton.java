package com.example.wikipedia.elements;

import static com.codeborne.selenide.Condition.visible;
import java.time.Duration;


public class GalleryCloseButton extends ClickableElement {
    private static final int TIMEOUT = 3; 
    
    public GalleryCloseButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    public void clickAndWaitUntilClosed() {
        click(Duration.ofSeconds(TIMEOUT));
    }

    public void waitUntilOpened() {
        element.shouldBe(visible, Duration.ofSeconds(TIMEOUT));
    }

    public static GalleryCloseButton byTitle(String title){
        return new GalleryCloseButton(String.format(TITLE_XPATH, title), true);
    }
}

