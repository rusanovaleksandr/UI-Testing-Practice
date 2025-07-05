package com.example.wikipedia.elements;

import static com.codeborne.selenide.Selenide.$;

/**
 * Класс, представляющий кнопку для получения короткой ссылки.
 * Наследует функциональность InteractiveElement и предоставляет методы
 * для работы с диалогом получения коротких URL.
 */
public class ShortUrlButton extends InteractiveElement {
    
    /**
     * Конструктор для создания кнопки короткой ссылки.
     *
     * @param selector строка селектора для поиска элемента
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public ShortUrlButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Получает короткий URL из диалогового окна.
     * Метод ищет элемент ввода с классом oo-ui-inputWidget-input
     * и возвращает значение его атрибута value.
     *
     * @return строка с коротким URL
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент диалога не найден
     */
    public String getShortUrlFromDialog() {
        return $(".oo-ui-inputWidget-input").getAttribute("value");
    }

    /**
     * Фабричный метод для создания кнопки короткой ссылки по ID элемента.
     *
     * @param id ID элемента кнопки
     * @return новый экземпляр ShortUrlButton
     * @throws IllegalArgumentException если переданный ID равен null или пустой строке
     */
    public static ShortUrlButton byId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return new ShortUrlButton(String.format(ID_XPATH, id), true);
    }
}