package com.example.wikipedia.elements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

/**
 * Класс, представляющий кнопку закрытия галереи.
 * Наследует функциональность ClickableElement и предоставляет методы для работы
 * с кнопкой закрытия галереи изображений.
 */
public class GalleryCloseButton extends ClickableElement {
    /**
     * Конструктор для создания кнопки закрытия галереи.
     *
     * @param selector строка селектора для поиска элемента
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public GalleryCloseButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Выполняет клик по кнопке и ожидает закрытия галереи.
     * Использует стандартный таймаут (TIMEOUT) для ожидания.
     */
    public void clickAndWaitUntilClosed() {
        click(Duration.ofSeconds(TIMEOUT));
    }

    /**
     * Ожидает появления кнопки закрытия галереи (открытия галереи).
     * Использует стандартный таймаут (TIMEOUT) для ожидания.
     */
    public void waitUntilOpened() {
        element.shouldBe(visible, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * Фабричный метод для создания кнопки закрытия галереи по атрибуту title.
     *
     * @param title значение атрибута title элемента
     * @return новый экземпляр GalleryCloseButton
     */
    public static GalleryCloseButton byTitle(String title) {
        return new GalleryCloseButton(String.format(TITLE_XPATH, title), true);
    }
}