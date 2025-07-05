package com.example.wikipedia.elements;
import static com.codeborne.selenide.Condition.visible;
import java.time.Duration;


public abstract class ClickableElement extends BaseElement {
    public ClickableElement(String selector) {
        super(selector);
    }

    public ClickableElement(String locator, boolean isXpath) {
        super(locator, isXpath);
    }

    public void click() {
        element.shouldBe(visible).click();
    }

    public void click(Duration timeout) {
        element.shouldBe(visible, timeout).click();
    }
}