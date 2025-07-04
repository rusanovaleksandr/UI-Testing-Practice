package com.example.wikipedia.tests;

import com.example.wikipedia.pages.ArticlePage;
import org.junit.jupiter.api.Test;
import com.example.wikipedia.services.TestDataLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SearchTest extends BaseTest {

    private static final String TEST_ARTICLE_KEY = "test7_has_cite";
    private static final String NON_EXISTING_ARTICLE = "dfgdfgdfgdfg";

    @Test
    void searchExistingArticle() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        assertEquals(articleName, articlePage.getArticleTitle());
    }
    @Test
    void searchNonExistingArticle() {
        ArticlePage articlePage = mainPage.openArticle(NON_EXISTING_ARTICLE);
        assertNotEquals(TEST_ARTICLE_KEY, articlePage.getArticleTitle());
    }
}