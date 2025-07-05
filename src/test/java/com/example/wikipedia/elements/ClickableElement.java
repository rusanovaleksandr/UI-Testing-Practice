package com.example.wikipedia.elements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

/**
 * Абстрактный класс, представляющий кликабельный элемент страницы.
 * Наследует функциональность BaseElement и добавляет методы для взаимодействия с кликабельными элементами.
 * Гарантирует, что элемент видим перед выполнением клика.
 */
public abstract class ClickableElement extends BaseElement {
    /**
     * Конструктор для создания кликабельного элемента по CSS-селектору.
     *
     * @param selector CSS-селектор для поиска элемента
     */
    public ClickableElement(String selector) {
        super(selector);
    }

    /**
     * Конструктор для создания кликабельного элемента по локатору с указанием типа.
     *
     * @param locator строка локатора (XPath или CSS)
     * @param isXpath флаг, указывающий тип локатора (true - XPath, false - CSS)
     */
    public ClickableElement(String locator, boolean isXpath) {
        super(locator, isXpath);
    }

    /**
     * Кликает по элементу после проверки его видимости (с таймаутом по умолчанию).
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не становится видимым
     * в течение стандартного времени ожидания
     */
    public void click() {
        element.shouldBe(visible).click();
    }

    /**
     * Кликает по элементу после проверки его видимости с указанным таймаутом.
     *
     * @param timeout максимальное время ожидания появления элемента
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не становится видимым
     * в течение указанного времени
     */
    public void click(Duration timeout) {
        element.shouldBe(visible, timeout).click();
    }
}