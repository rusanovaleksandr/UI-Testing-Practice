package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestDataLoader;

/**
 * Тестовый класс для проверки функциональности галереи статей.
 * Проверяет возможность открытия и закрытия галереи на странице статьи.
 */
public class GalleryTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test4_has_image";
    
    /**
     * Тестирует открытие и закрытие галереи на странице статьи.
     * Проверяет, что галерея открывается и закрывается корректно.
     */
    @Test
    void shouldOpenAndCloseGallery() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        articlePage.openGallery();
        articlePage.waitUntilGalleryIsOpened();
        assertTrue(articlePage.isGalleryVisible(), "Галерея должна быть видима после открытия");
        articlePage.closeGallery();
        assertFalse(articlePage.isGalleryVisible(), "Галерея должна быть закрыта после закрытия");
    }
}
