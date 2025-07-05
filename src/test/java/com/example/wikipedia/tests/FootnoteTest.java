package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestDataLoader;

public class FootnoteTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test9_has_notes";
    private static final String EXPECTED_ANCHOR = "#cite_note";
    private static final String BACK_ANCHOR = "#cite_ref";

    @Test
    void footnoteShouldWorkCorrectly() {
        // Загрузка тестовых данных
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи");

        // Шаги теста
        ArticlePage articlePage = mainPage.openArticle(articleName);

        // 1. Проверка кликабельности сноски
        articlePage.clickFootnote();

        // 2. Проверка URL после клика
        assertTrue(articlePage.urlContainsAnchor(EXPECTED_ANCHOR),
                "URL должен содержать якорь " + EXPECTED_ANCHOR);

        // 3. Проверка видимости кнопки возврата
        assertTrue(articlePage.isBackToTextButtonVisible(),
                "Кнопка возврата должна отображаться");

        // 4. Клик на кнопку возврата
        articlePage.clickBackToTextButton();

        // 5. Проверка URL после возврата
        assertFalse(articlePage.urlContainsAnchor(EXPECTED_ANCHOR),
                "URL не должен содержать якорь после возврата");
        assertTrue(articlePage.urlContainsAnchor(BACK_ANCHOR),
                "URL должен содержать ref якорь после возврата");
    }
}
