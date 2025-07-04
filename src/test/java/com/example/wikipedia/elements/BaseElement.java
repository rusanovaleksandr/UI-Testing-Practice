package com.example.wikipedia.elements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

public abstract class BaseElement {
    protected static final String ID_XPATH = "//*[@id='%s']";
    protected static final String TITLE_XPATH = "//*[contains(@title, '%s')]";
    protected static final String NAME_XPATH = "//*[@name='%s']";
    protected static final String CLASS_XPATH = "//*[@class='%s']";
    protected static final String TYPE_XPATH = "//*[@type='%s']";
    protected final SelenideElement element;
    protected static final int TIMEOUT = 10;

    public BaseElement(String selector) {
        this.element = $(selector);
    }

    public BaseElement(String locator, boolean isXpath) {
        this.element = isXpath ? $x(locator) : $(locator);
    }

    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
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
}