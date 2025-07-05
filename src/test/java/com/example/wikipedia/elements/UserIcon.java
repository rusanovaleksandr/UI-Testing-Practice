package com.example.wikipedia.elements;

/**
 * Класс, представляющий иконку пользователя на веб-странице.
 * Наследует функциональность InteractiveElement и предоставляет методы
 * для работы с пользовательской иконкой.
 */
public class UserIcon extends InteractiveElement {
    
    /**
     * Конструктор для создания элемента пользовательской иконки.
     *
     * @param selector строка селектора для поиска элемента
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public UserIcon(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Получает текст, связанный с иконкой пользователя.
     * Может возвращать имя пользователя или другой текст, отображаемый на иконке.
     *
     * @return текст иконки пользователя
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не найден
     */
    public String getText() {
        return element.getText();
    }

    /**
     * Фабричный метод для создания элемента иконки пользователя по ID.
     *
     * @param id ID элемента иконки пользователя
     * @return новый экземпляр UserIcon
     * @throws IllegalArgumentException если переданный ID равен null или пустой строке
     */
    public static UserIcon byId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return new UserIcon(String.format(ID_XPATH, id), true);
    }
}