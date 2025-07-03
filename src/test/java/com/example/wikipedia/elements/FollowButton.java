package com.example.wikipedia.elements;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class FollowButton extends BaseElement {
    private static final String WATCH_ID = "#ca-watch";
    private static final String UNWATCH_ID = "#ca-unwatch";
    
    public FollowButton() {
        super(WATCH_ID + ", " + UNWATCH_ID);
    }

    public boolean isActive() {
        return $(UNWATCH_ID).exists();
    }

    public void unwatchButtonShouldBeVisible(){
        $(UNWATCH_ID).shouldBe(visible, ofSeconds(3));
    }

    public void watchButtonShouldBeVisible(){
        $(WATCH_ID).is(visible, ofSeconds(3));
    }

    public static FollowButton byDefault() {
        return new FollowButton();
    }
}