package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestDataLoader;

public class GalleryTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test4_has_image";

    @Test
    void shouldOpenAndCloseGallery(){
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        articlePage.openGallery();
        articlePage.waitUntilGalleryIsOpened();
        assertTrue(articlePage.isGalleryVisible());
        articlePage.closeGallery();
        assertFalse(articlePage.isGalleryVisible());
    }
}