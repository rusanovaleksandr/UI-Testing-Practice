package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestDataLoader;

/**
 * Тестовый класс для проверки переключения языковой версии статьи.
 * Убеждается, что статья корректно отображается на английском языке после переключения.
 */
public class LanguageSwitchTest extends BaseTest{
    private static final String TEST_ARTICLE_KEY = "test10_has_english";

    /**
     * Тестирует переключение на английскую версию статьи.
     * Проверяет смену домена в URL, наличие переведенного заголовка
     * и стандартные элементы английской версии Wikipedia.
     */
    @Test
    void shouldSwitchToEnglishVersion() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Название статьи не найдено в тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        assertTrue(articlePage.hasEnglishVersion());
        ArticlePage enArticlePage = articlePage.switchToEnglish();
        String currentUrl = enArticlePage.getCurrentUrl();
        assertTrue(currentUrl.contains("en.wikipedia.org"),
                "URL должен содержать en.wikipedia.org. Фактический URL: " + currentUrl);
        String translatedTitle = enArticlePage.getArticleTitle();
        assertNotNull(translatedTitle, "Заголовок на английском отсутствует");
        assertTrue(enArticlePage.hasEnglishTemplate().contains("From Wikipedia, the free encyclopedia"));
    }
}

