package com.example.wikipedia.tests;

import com.example.wikipedia.pages.ArticlePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.wikipedia.services.TestDataLoader;


public class ShortUrlGenerationTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test5_short_url";

    @Test
    void shouldGenerateValidShortUrl() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        String originalTitle = articlePage.getArticleTitle();
        String shortUrl = articlePage.getShortUrl();
        assertTrue(shortUrl.startsWith("https://w.wiki/"), 
            "Сгенерированный URL должен начинаться с https://w.wiki/");
        articlePage.open(shortUrl);
        assertEquals(originalTitle, articlePage.getArticleTitle(),
            "Заголовок статьи должен совпадать с оригиналом");

    }
}