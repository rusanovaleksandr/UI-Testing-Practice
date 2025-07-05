package com.example.wikipedia.tests;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.pages.CitationPage;
import org.junit.jupiter.api.Test;
import com.example.wikipedia.services.TestDataLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CiteButtonTest extends BaseTest {

    private static final String TEST_ARTICLE_KEY = "test7_has_cite";


    @Test
    public void citeButtonOpensCitationPage() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");

        ArticlePage articlePage = mainPage.openArticle(articleName);
        CitationPage citationPage = articlePage.clickCiteButton();

        String headingText = citationPage.getCitationHeadingText();
        assertEquals("Библиографические ссылки на статью", headingText);
    }
}