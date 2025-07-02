package com.example.wikipedia.elements;

import com.example.wikipedia.core.BaseElement;
import static com.codeborne.selenide.Condition.visible;

public class SearchResultLink extends BaseElement {
    public SearchResultLink(String articleName) {
        super(String.format("//a[@title='%s']", articleName));
    }
    
    public void click() {
        element.shouldBe(visible).click();
    }
}