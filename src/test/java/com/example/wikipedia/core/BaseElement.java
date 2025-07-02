package com.example.wikipedia.core;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class BaseElement {
    protected final SelenideElement element;
    protected static final int TIMEOUT = 10;

    public BaseElement(String selector) {
        this.element = $(selector);
    }

    public boolean isDisplayed() {
        try {
            return element.shouldBe(visible).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayed(Duration timeout) {
        try {
            element.shouldBe(visible, timeout);
            return true;
        } catch (ElementNotFound e) {
            return false;
        }
    }

    public void click()
    {
        element.shouldBe(visible).click();
    }
}