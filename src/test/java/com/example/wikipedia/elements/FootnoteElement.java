package com.example.wikipedia.elements;

/**
 * Представляет элемент сноски в статье.
 * Наследует функциональность {@link ClickableElement} и предоставляет методы
 * для взаимодействия со сносками через их номер.
 */
public class FootnoteElement extends ClickableElement {
    private static final String FOOTNOTE_XPATH =
            "//sup[@class='reference']/a[contains(@href, 'cite_note') and contains(text(), '%s')]";

    /**
     * Конструктор для создания элемента сноски.
     *
     * @param selector селектор элемента
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public FootnoteElement(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Фабричный метод для создания элемента по номеру сноски.
     *
     * @param number номер сноски
     * @return экземпляр {@link FootnoteElement}
     */
    public static FootnoteElement byFootnoteNumber(String number) {
        String xpath = String.format(FOOTNOTE_XPATH, number);
        return new FootnoteElement(xpath, true);
    }
}
