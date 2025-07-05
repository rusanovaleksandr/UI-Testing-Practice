package com.example.wikipedia.elements;

import static com.codeborne.selenide.Condition.visible;

/**
 * Класс, представляющий сообщение о неверных учетных данных при входе в систему.
 * Наследует функциональность BaseElement и предоставляет методы для работы
 * с сообщениями об ошибках авторизации.
 */
public class WrongLoginMessage extends BaseElement {
    
    /**
     * Конструктор для создания элемента сообщения о неверном входе.
     *
     * @param selector строка селектора для поиска элемента сообщения
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public WrongLoginMessage(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Получает текст сообщения об ошибке входа.
     * Перед получением текста проверяет видимость элемента.
     * Возвращаемый текст обрезается от пробельных символов по краям.
     *
     * @return очищенный текст сообщения об ошибке
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не найден или не видим
     */
    public String getMessageText() {
        return element
            .shouldBe(visible)
            .getText()
            .trim();
    }

    /**
     * Фабричный метод для создания элемента сообщения по классу.
     *
     * @param class_name название CSS класса элемента сообщения
     * @return новый экземпляр WrongLoginMessage
     * @throws IllegalArgumentException если class_name равен null или пустой строке
     */
    public static WrongLoginMessage byClass(String class_name) {
        if (class_name == null || class_name.trim().isEmpty()) {
            throw new IllegalArgumentException("Class name cannot be null or empty");
        }
        return new WrongLoginMessage(String.format(CLASS_XPATH, class_name), true);
    }
}