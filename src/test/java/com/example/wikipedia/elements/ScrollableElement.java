package com.example.wikipedia.elements;

/**
 * Абстрактный класс, представляющий прокручиваемый элемент веб-страницы.
 * Наследуется от базового элемента(BaseElement) и добавляет функциональность прокрутки к элементу.
 * Предназначен для создания элементов, которые могут быть скрыты вне зоны видимости и требуют скролла.
 */
public abstract class ScrollableElement extends BaseElement {
    /**
     * Создает экземпляр прокручиваемого элемента с указанным CSS-селектором.
     *
     * @param selector CSS-селектор для поиска элемента
     */
    public ScrollableElement(String selector) {
        super(selector);
    }

    /**
     * Прокручивает страницу к текущему элементу.
     * Использует стандартную реализацию Selenide {@code scrollTo()}
     */
    public void scrollTo() {
        element.scrollTo();
    }
}