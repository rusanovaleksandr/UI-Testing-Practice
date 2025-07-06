package com.example.wikipedia.pages;

import com.example.wikipedia.elements.CitationHeading;

/**
 * Класс, представляющий страницу цитаты в Wikipedia.
 * Наследуется от (BasePage) и предоставляет методы для работы с заголовком цитаты.
 */
public class CitationPage extends BasePage {
    private final CitationHeading citationHeading = CitationHeading.byDefault();

    /**
     * Создает новый экземпляр страницы цитаты.
     * Вызывает конструктор родительского класса {@link BasePage}.
     */
    public CitationPage() {
        super();
    }

    /**
     * Получает текст заголовка цитаты.
     * @return текст заголовка цитаты
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не отображается
     *         в течение стандартного времени ожидания
     */
    public String getCitationHeadingText() {
        return citationHeading.getText();
    }
}