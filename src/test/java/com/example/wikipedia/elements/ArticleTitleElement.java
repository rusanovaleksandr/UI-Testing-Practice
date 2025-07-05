package com.example.wikipedia.elements;

/**
 * Класс, представляющий элемент заголовка статьи в Wikipedia.
 * Наследует функциональность базового элемента (BaseElement) и предоставляет
 * методы для работы с заголовками статей.
 */
public class ArticleTitleElement extends BaseElement {
    /**
     * Конструктор для создания экземпляра ArticleTitleElement с указанным селектором.
     *
     * @param selector строка-селектор для поиска элемента заголовка
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS селектор)
     */
    public ArticleTitleElement(String selector, boolean xpath) {
        super(selector, xpath);
    }
    
    /**
     * Получает текст заголовка статьи.
     *
     * @return строку с текстом заголовка статьи
     */
    public String getText() {
        return element.getText();
    }

    /**
     * Статический фабричный метод для создания ArticleTitleElement по ID элемента.
     *
     * @param id ID элемента заголовка
     * @return новый экземпляр ArticleTitleElement, связанный с элементом по указанному ID
     */
    public static ArticleTitleElement byId(String id) {
        return new ArticleTitleElement(String.format(ID_XPATH, id), true);
    }
}