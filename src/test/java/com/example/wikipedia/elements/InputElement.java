package com.example.wikipedia.elements;

/**
 * Класс, представляющий элемент ввода (input) на веб-странице.
 * Наследует функциональность BaseElement и предоставляет методы для взаимодействия
 * с полями ввода текста.
 */
public class InputElement extends BaseElement {
    /**
     * Конструктор для создания элемента ввода.
     *
     * @param selector строка селектора для поиска элемента
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public InputElement(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Заполняет поле ввода указанным текстом.
     *
     * @param text текст для ввода в поле
     */
    public void fill(String text) {
        element.setValue(text);
    }

    /**
     * Очищает содержимое поля ввода.
     */
    public void clear() {
        element.clear();
    }

    /**
     * Фабричный метод для создания элемента ввода по ID.
     *
     * @param id ID элемента ввода
     * @return новый экземпляр InputElement
     */
    public static InputElement byId(String id) {
        return new InputElement(String.format(ID_XPATH, id), true);
    }

    /**
     * Фабричный метод для создания элемента ввода по атрибуту name.
     *
     * @param name значение атрибута name элемента ввода
     * @return новый экземпляр InputElement
     */
    public static InputElement byName(String name) {
        return new InputElement(String.format(NAME_XPATH, name), true);
    }
}