package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestDataLoader;

/**
 * Тестовый класс для проверки функциональности сносок в статьях.
 * Проверяет корректность перехода по сноскам и возврата к основному тексту.
 */
public class FootnoteTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test9_has_notes";
    private static final String EXPECTED_ANCHOR = "#cite_note";
    private static final String BACK_ANCHOR = "#cite_ref";

    /**
     * Тестирует работу сносок: переход по ссылке сноски, отображение кнопки возврата
     * и корректность возврата к исходному тексту статьи.
     * Проверяет изменения URL и наличие соответствующих якорей.
     */
    @Test
    void footnoteShouldWorkCorrectly() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи");

        ArticlePage articlePage = mainPage.openArticle(articleName);

        articlePage.clickFootnote();

        assertTrue(articlePage.urlContainsAnchor(EXPECTED_ANCHOR),
                "URL должен содержать якорь " + EXPECTED_ANCHOR);

        assertTrue(articlePage.isBackToTextButtonVisible(),
                "Кнопка возврата должна отображаться");

        articlePage.clickBackToTextButton();

        assertFalse(articlePage.urlContainsAnchor(EXPECTED_ANCHOR),
                "URL не должен содержать якорь после возврата");
        assertTrue(articlePage.urlContainsAnchor(BACK_ANCHOR),
                "URL должен содержать ref якорь после возврата");
    }
}
