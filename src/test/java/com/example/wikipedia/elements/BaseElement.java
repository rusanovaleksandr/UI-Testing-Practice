package com.example.wikipedia.elements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

/**
 * Абстрактный базовый класс для всех элементов веб-страницы.
 * Предоставляет общие методы для работы с веб-элементами и стандартные локаторы.
 */
public abstract class BaseElement {
    /** XPath для поиска по ID */
    protected static final String ID_XPATH = "//*[@id='%s']";
    /** XPath для поиска по атрибуту title */
    protected static final String TITLE_XPATH = "//*[contains(@title, '%s')]";
    /** XPath для поиска по атрибуту name */
    protected static final String NAME_XPATH = "//*[@name='%s']";
    /** XPath для поиска по атрибуту class */
    protected static final String CLASS_XPATH = "//*[@class='%s']";
    /** XPath для поиска по атрибуту type */
    protected static final String TYPE_XPATH = "//*[@type='%s']";
    /** Веб-элемент, с которым работает данный объект */
    protected final SelenideElement element;
    /** Таймаут по умолчанию для ожиданий (в секундах) */
    protected static final int TIMEOUT = 10;

    /**
     * Конструктор для создания элемента по CSS-селектору.
     *
     * @param selector CSS-селектор для поиска элемента
     */
    public BaseElement(String selector) {
        this.element = $(selector);
    }

    /**
     * Конструктор для создания элемента по локатору с указанием типа.
     *
     * @param locator строка локатора (XPath или CSS)
     * @param isXpath флаг, указывающий тип локатора (true - XPath, false - CSS)
     */
    public BaseElement(String locator, boolean isXpath) {
        this.element = isXpath ? $x(locator) : $(locator);
    }

    /**
     * Проверяет, доступен ли элемент (существует и отображается на странице).
     *
     * @return true если элемент доступен, false в противном случае
     */
    public boolean isAvailable() {
        return element.exists() && element.isDisplayed();
    }

    /**
     * Проверяет, отображается ли элемент на странице с таймаутом по умолчанию.
     *
     * @return true если элемент отображается, false в противном случае
     */
    public boolean isDisplayed() {
        try {
            return element.shouldBe(visible).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Проверяет существование элемента на странице.
     *
     * @return true если элемент существует в DOM, false в противном случае
     */
    public boolean exists(){
        return element.exists();
    }

    /**
     * Проверяет, отображается ли элемент на странице с указанным таймаутом.
     *
     * @param timeout максимальное время ожидания появления элемента
     * @return true если элемент отобразился в течение таймаута, false в противном случае
     */
    public boolean isDisplayed(Duration timeout) {
        try {
            element.shouldBe(visible, timeout);
            return true;
        } catch (ElementNotFound e) {
            return false;
        }
    }
}