package com.example.wikipedia.elements;

/**
 * Класс, представляющий секцию статьи в Wikipedia.
 * Наследует функциональность базового элемента (BaseElement) и предоставляет
 * методы для работы с секциями статей.
 */
public class ArticleSection extends BaseElement {
    /**
     * Конструктор для создания экземпляра ArticleSection с указанным селектором.
     *
     * @param selector строка-селектор для поиска элемента
     * @param xpath флаг, указывающий, является ли селектор XPath-выражением
     *             (true - XPath, false - CSS-селектор)
     */
    public ArticleSection(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Статический фабричный метод для создания ArticleSection по ID элемента.
     *
     * @param id ID элемента, по которому будет создана секция
     * @return новый экземпляр ArticleSection, связанный с элементом по указанному ID
     */
    public static ArticleSection byId(String id) {
        return new ArticleSection(String.format(ID_XPATH, id), true); 
    }
}