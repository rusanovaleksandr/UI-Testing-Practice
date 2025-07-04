package com.example.wikipedia.elements;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class FollowButton extends BaseElement {
    private static final String TWO_IDS_XPATH = "//*[@id='%s' or @id='%s']";
    private static final String DEFAULT_WATCH_ID = "ca-watch";
    private static final String DEFAULT_UNWATCH_ID = "ca-unwatch";
    private final String watch_button_selector;
    private final String unwatch_button_selector;
    
    public FollowButton(String watch_id, String unwatch_id, boolean xpath) {
        super(String.format(TWO_IDS_XPATH,watch_id, unwatch_id), xpath);
        this.watch_button_selector = String.format("#%s",watch_id);
        this.unwatch_button_selector = String.format("#%s",unwatch_id);
    }

    public boolean isActive() {
        return $(unwatch_button_selector).exists();
    }

    public void unwatchButtonShouldBeVisible(){
        $(unwatch_button_selector).shouldBe(visible, ofSeconds(3));
    }

    public void watchButtonShouldBeVisible(){
        $(watch_button_selector).is(visible, ofSeconds(3));
    }

    public static FollowButton byIds(String watch_id, String unwatch_id){
        return new FollowButton(watch_id, unwatch_id, true);
    }

    public static FollowButton byDefault() {
        return new FollowButton(DEFAULT_WATCH_ID, DEFAULT_UNWATCH_ID, true);
    }
}