package com.example.wikipedia.tests;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.elements.BodyElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.wikipedia.services.TestDataLoader;


import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Тестовый класс для проверки функциональности раздела "Ссылки" в статьях Wikipedia.
 * Проверяет корректность работы ссылок на внешние ресурсы в разделе библиографических ссылок.
 */
public class ReferencesTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test8_has_references";

    /**
     * Проверяет корректность перехода по внешней ссылке из раздела "Ссылки".
     * Прокручивает страницу к разделу "Ссылки"
     * Проверяет наличие хотя бы одной ссылки в разделе
     * Кликает по первой ссылке в разделе
     * Проверяет, что переход выполнен на внешний ресурс (не Wikipedia)
     * Убеждается, что целевая страница загружена
     */
    @Test
    void firstReferenceLinkShouldOpenExternalResource() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        articlePage.scrollToReferencesSection();
        assertTrue(articlePage.referencesSectionHasLinks(), "Раздел 'Ссылки' не содержит источников");
        articlePage.clickFirstReferenceLink();
        String currentUrl = com.codeborne.selenide.Selenide.webdriver().driver().url();
        assertFalse(currentUrl.contains("wikipedia.org"), "Переход на внешний ресурс не произошел");
        BodyElement body = new BodyElement();
        assertTrue(body.isDisplayed(), "Страница не загружена корректно");
    }
}