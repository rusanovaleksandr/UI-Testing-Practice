package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.pages.CitationPage;
import com.example.wikipedia.services.TestDataLoader;

/**
 * Тестовый класс для проверки функциональности кнопки "Цитировать".
 * Проверяет корректность открытия страницы библиографических ссылок при нажатии на кнопку цитирования.
 */
public class CiteButtonTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test7_has_cite";

    /**
     * Проверяет, что статья успешно загружается по имени.
     * Кнопка цитирования доступна для взаимодействия.
     * Происходит корректный переход на страницу цитирования.
     * Заголовок страницы соответствует ожидаемому.
     */
    @Test
    public void citeButtonOpensCitationPage() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        CitationPage citationPage = articlePage.clickCiteButton();
        assertEquals("Библиографические ссылки на статью", citationPage.getCitationHeadingText());
    }
}