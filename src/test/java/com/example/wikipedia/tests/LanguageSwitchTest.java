package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestDataLoader;

public class LanguageSwitchTest extends BaseTest{
    private static final String TEST_ARTICLE_KEY = "test10_has_english";

    @Test
    void shouldSwitchToEnglishVersion() {

        // Загрузить тестовые данные
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Название статьи не найдено в тестовых данных");

        // Перейти на статью
        ArticlePage articlePage = mainPage.openArticle(articleName);

        // Проверка 1: Ссылка "English" доступна
        assertTrue(articlePage.hasEnglishVersion());

        // Переключиться на английскую версию
        ArticlePage enArticlePage = articlePage.switchToEnglish();

        // Проверка 2: URL изменен
        String currentUrl = enArticlePage.getCurrentUrl();
        assertTrue(currentUrl.contains("en.wikipedia.org"),
                "URL должен содержать en.wikipedia.org. Фактический URL: " + currentUrl);

        // Проверка 3: Заголовок сохранился (с учетом перевода)
        String translatedTitle = enArticlePage.getArticleTitle();
        assertNotNull(translatedTitle, "Заголовок на английском отсутствует");

        // Проверка 4: Наличие шаблонной строки
        assertTrue(enArticlePage.hasEnglishTemplate().contains("From Wikipedia, the free encyclopedia"));
    }
}

