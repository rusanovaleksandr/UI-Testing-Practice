package com.example.wikipedia.elements;

import static com.codeborne.selenide.Condition.visible;

/**
 * Класс, представляющий заголовок цитаты на странице Wikipedia.
 * Наследуется от базового элемента(BaseElement) и использует CSS-селектор по умолчанию "#firstHeading".
 * Предоставляет методы для получения текста заголовка и создания экземпляра по умолчанию.
 * Гарантирует, что элемент видим перед выполнением операций.
 */
public class CitationHeading extends BaseElement {
    /**
     * CSS-селектор по умолчанию для заголовка цитаты.
     */
    private static final String DEFAULT_CSS_SELECTOR = "#firstHeading";

    /**
     * Создает экземпляр элемента с использованием CSS-селектора по умолчанию.
     */
    public CitationHeading() {
        super(DEFAULT_CSS_SELECTOR);
    }

    /**
     * Возвращает текст заголовка после проверки его видимости.
     *
     * @return текст заголовка цитаты
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не становится видимым
     *         в течение стандартного времени ожидания
     */
    public String getText() {
        return element.shouldBe(visible).getText();
    }

    /**
     * Статический фабричный метод для создания экземпляра с селектором по умолчанию.
     *
     * @return новый экземпляр CitationHeading
     */
    public static CitationHeading byDefault(){
        return new CitationHeading();
    }    
}