package com.example.wikipedia.tests;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.pages.MainPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.wikipedia.services.TestDataLoader;


public class ShortUrlGenerationTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test5_short_url";

    @Test
    void shouldGenerateValidShortUrl() {
        // 1. Получаем тестовые данные
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");

        // 2. Открываем главную страницу
        MainPage mainPage = new MainPage();
        mainPage.open();

        // 3. Выполняем поиск и открываем статью
        ArticlePage articlePage = mainPage.openArticle(articleName);
        String originalTitle = articlePage.getArticleTitle();
        
        // 5. Генерируем и копируем короткий URL
        String shortUrl = articlePage.getShortUrl();
        
        // 6. Проверяем формат URL
        assertTrue(shortUrl.startsWith("https://w.wiki/"), 
            "Сгенерированный URL должен начинаться с https://w.wiki/");
        
        // 7. Открываем в новой вкладке
        ArticlePage newTabPage = articlePage.openShortUrlInNewTab(shortUrl);
        
        // 8. Проверяем заголовок
        assertEquals(originalTitle, newTabPage.getArticleTitle(),
            "Заголовок статьи должен совпадать с оригиналом");

        newTabPage.closeCurrentTabAndSwitchToOriginal();

        articlePage.closeShortUrlDialog();


    }
}