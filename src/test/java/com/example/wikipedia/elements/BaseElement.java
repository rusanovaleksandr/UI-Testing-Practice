package com.example.wikipedia.elements;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
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

    public BaseElement(String locator, boolean isXpath) {
        this.element = isXpath ? $x(locator) : $(locator);
    }

    public boolean isDisplayed() {
        try {
            return element.shouldBe(visible).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean exists(){
        return element.exists();
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