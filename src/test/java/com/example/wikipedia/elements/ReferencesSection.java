package com.example.wikipedia.elements;

import com.codeborne.selenide.ElementsCollection;

/**
 * Класс, представляющий раздел "Ссылки" на странице Wikipedia.
 * Наследуется от (ScrollableElement), обеспечивая автоматическую прокрутку к элементу при необходимости.
 * Предоставляет методы для взаимодействия со ссылками в разделе.
 */
public class ReferencesSection extends ScrollableElement {
    /**
     * CSS-селектор по умолчанию для раздела "Ссылки".
     * Соответствует HTML-элементу с id="Ссылки".
     */
    public static final String DEFAULT_SELECTOR = "#Ссылки";

    /**
     * Создает экземпляр раздела ссылок с использованием указанного селектора.
     *
     * @param selector CSS-селектор для поиска раздела ссылок
     */
    public ReferencesSection(String selector) {
        super(selector);
    }

    /**
     * Кликает по первой ссылке в разделе.
     *
     * <p><b>Внимание:</b> Не выполняет проверку видимости/кликабельности ссылки.
     * При необходимости добавьте ожидания в наследующих классах.</p>
     *
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент раздела не найден
     */
    public void clickFirstLink() {
        element.$("a").click();
    }

    /**
     * Проверяет наличие ссылок в разделе.
     *
     * @return true если в разделе есть хотя бы одна ссылка, иначе false
     */
    public boolean hasLinks() {
        ElementsCollection links = element.$$("a");
        return !links.isEmpty();
    }

    /**
     * Создает экземпляр класса с селектором по умолчанию ({@value #DEFAULT_SELECTOR}).
     *
     * @return новый экземпляр ReferencesSection
     */
    public static ReferencesSection byDefault() {
        return new ReferencesSection(DEFAULT_SELECTOR);
    }
}