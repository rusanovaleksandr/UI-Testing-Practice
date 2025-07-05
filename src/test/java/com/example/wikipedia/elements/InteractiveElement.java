package com.example.wikipedia.elements;

/**
 * Класс, представляющий интерактивный элемент страницы, с которым можно взаимодействовать.
 * Наследует функциональность ClickableElement и предоставляет фабричные методы
 * для создания элементов по различным атрибутам.
 */
public class InteractiveElement extends ClickableElement {
    
    /**
     * Конструктор для создания интерактивного элемента по CSS-селектору.
     *
     * @param selector CSS-селектор для поиска элемента
     */
    public InteractiveElement(String selector) {
        super(selector);
    }

    /**
     * Конструктор для создания интерактивного элемента по локатору с указанием типа.
     *
     * @param locator строка локатора (XPath или CSS)
     * @param isXpath флаг, указывающий тип локатора (true - XPath, false - CSS)
     */
    public InteractiveElement(String locator, boolean isXpath) {
        super(locator, isXpath);
    }

    /**
     * Фабричный метод для создания элемента по ID.
     *
     * @param id ID элемента
     * @return новый экземпляр InteractiveElement
     */
    public static InteractiveElement byId(String id) {
        return new InteractiveElement(String.format(ID_XPATH, id), true);
    }

    /**
     * Фабричный метод для создания элемента по атрибуту type.
     *
     * @param type значение атрибута type
     * @return новый экземпляр InteractiveElement
     */
    public static InteractiveElement byType(String type) {
        return new InteractiveElement(String.format(TYPE_XPATH, type), true);
    }

    /**
     * Фабричный метод для создания элемента по атрибуту title.
     *
     * @param title значение атрибута title
     * @return новый экземпляр InteractiveElement
     */
    public static InteractiveElement byTitle(String title) {
        return new InteractiveElement(String.format(TITLE_XPATH, title), true);
    }

    /**
     * Фабричный метод для создания элемента по атрибуту name.
     *
     * @param name значение атрибута name
     * @return новый экземпляр InteractiveElement
     */
    public static InteractiveElement byName(String name) {
        return new InteractiveElement(String.format(NAME_XPATH, name), true);
    }

    /**
     * Фабричный метод для создания элемента по CSS-селектору.
     *
     * @param css_selector CSS-селектор элемента
     * @return новый экземпляр InteractiveElement
     */
    public static InteractiveElement bySelector(String css_selector) {
        return new InteractiveElement(css_selector, false);
    }
}