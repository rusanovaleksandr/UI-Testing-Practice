package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestDataLoader;



public class ShortUrlGenerationTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test5_short_url";
    private static final String SHORT_URL_PREFIX = "https://w.wiki/";

    @Test
    void shouldGenerateValidShortUrl() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        String originalTitle = articlePage.getArticleTitle();
        articlePage.openShortUrlDialogWindow();
        String shortUrl = articlePage.getShortUrlFromDialogWindow();
        assertTrue(shortUrl.startsWith(SHORT_URL_PREFIX),
                "Сгенерированный URL должен начинаться с " + SHORT_URL_PREFIX);
        articlePage.open(shortUrl);
        assertEquals(originalTitle, articlePage.getArticleTitle(),
                "Заголовок статьи должен совпадать с оригиналом");

    }
}