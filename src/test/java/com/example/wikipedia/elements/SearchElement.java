package com.example.wikipedia.elements;

/**
 * Класс, представляющий поле поиска на веб-странице.
 * Наследует функциональность InputElement и добавляет специфичные для поиска методы.
 * Предоставляет возможность выполнения поисковых запросов.
 */
public class SearchElement extends InputElement {
    
    /**
     * Конструктор для создания элемента поиска.
     *
     * @param selector строка селектора для поиска элемента
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public SearchElement(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Выполняет поиск по указанному запросу.
     * Вводит текст в поле поиска и имитирует нажатие клавиши Enter.
     *
     * @param query поисковый запрос для ввода в поле
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не найден или недоступен
     */
    public void search(String query) {
        element.setValue(query).pressEnter();
    }

    /**
     * Фабричный метод для создания элемента поиска по классу.
     *
     * @param class_name название CSS класса элемента поиска
     * @return новый экземпляр SearchElement
     * @throws IllegalArgumentException если class_name равен null или пустой строке
     */
    public static SearchElement byClass(String class_name) {
        if (class_name == null || class_name.trim().isEmpty()) {
            throw new IllegalArgumentException("Class name cannot be null or empty");
        }
        return new SearchElement(String.format(CLASS_XPATH, class_name), true);
    }
}