package com.example.wikipedia.elements;

/**
 * Класс, представляющий элемент {@code <body>} веб-страницы.
 * Наследуется от базового элемента(BaseElement) и использует CSS-селектор "body".
 * Предназначен для базовых операций с основным контейнером страницы.
 */
public class BodyElement extends BaseElement {
    /**
     * Создает экземпляр элемента body, используя CSS-селектор "body".
     * Конструктор гарантирует, что элемент будет найден на любой HTML-странице.
     */
    public BodyElement() {
        super("body");
    }
}