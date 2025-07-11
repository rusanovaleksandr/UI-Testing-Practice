package com.example.wikipedia.tests;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestResults;

/**
 * Тестовый класс для поиска статей с определенными условиями.
 * Проверяет наличие различных элементов на случайно выбранных статьях.
 */
public class FindArticlesTest extends BaseTest {
    private static final int MAX_ATTEMPTS = 10;
    private static final String TEST_HAS_FOLLOW = "test2_has_follow";
    private static final String TEST_HAS_IMAGE = "test4_has_image";
    private static final String TEST_SHORT_URL = "test5_short_url";
    private static final String TEST_HAS_TITLE = "test6_has_title";
    private static final String TEST_HAS_CITE = "test7_has_cite";
    private static final String TEST_HAS_REFERENCES = "test8_has_references";
    private static final String TEST_HAS_NOTES = "test9_has_notes";
    private static final String TEST_HAS_ENGLISH = "test10_has_english";
    private static final String TEST_HAS_PDF = "test11_has_pdf";
    
    /**
     * Тестирует наличие различных элементов на случайно выбранных статьях.
     * Выполняет до MAX_ATTEMPTS попыток для нахождения статей, соответствующих условиям.
     */
    @Test
    void findArticlesWithConditions() {
        Map<String, Boolean> conditions = new HashMap<>() {{
            put(TEST_HAS_FOLLOW, false);
            put(TEST_HAS_IMAGE, false);
            put(TEST_SHORT_URL, false);
            put(TEST_HAS_TITLE, false);
            put(TEST_HAS_CITE, false);
            put(TEST_HAS_REFERENCES, false);
            put(TEST_HAS_NOTES, false);
            put(TEST_HAS_ENGLISH, false);
            put(TEST_HAS_PDF, false);
        }};
        
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            if (!conditions.containsValue(false)) break;
            ArticlePage article = mainPage.openRandomArticle();
            article.scrollToFooter();
            checkAndUpdateCondition(conditions, article, TEST_HAS_FOLLOW, article.hasFollowButton());
            checkAndUpdateCondition(conditions, article, TEST_HAS_IMAGE, article.hasImages());
            checkAndUpdateCondition(conditions, article, TEST_SHORT_URL, article.hasShortUrlOption());
            checkAndUpdateCondition(conditions, article, TEST_HAS_TITLE, true);
            checkAndUpdateCondition(conditions, article, TEST_HAS_CITE, article.hasCiteOption());
            checkAndUpdateCondition(conditions, article, TEST_HAS_REFERENCES, article.hasReferencesSection());
            checkAndUpdateCondition(conditions, article, TEST_HAS_NOTES, article.hasNotesSection());
            checkAndUpdateCondition(conditions, article, TEST_HAS_ENGLISH, article.hasEnglishVersion());
            checkAndUpdateCondition(conditions, article, TEST_HAS_PDF, article.hasPdfDownload());      
        }
        
        conditions.forEach((testName, found) -> {
            assertTrue(found, "Статья для теста " + testName + " не найдена за " + MAX_ATTEMPTS + " попыток");
        });
    }

    /**
     * Проверяет, выполнено ли условие для статьи, и обновляет состояние условий.
     *
     * @param conditions карта условий, где ключ - имя условия, а значение - его состояние
     * @param article экземпляр ArticlePage, представляющий проверяемую статью
     * @param conditionName имя условия для проверки
     * @param conditionMet результат проверки условия
     */
    private void checkAndUpdateCondition(Map<String, Boolean> conditions, ArticlePage article, 
                                       String conditionName, boolean conditionMet) {
        if (!conditions.get(conditionName) && conditionMet) {
            TestResults.addResult(conditionName, article.getArticleTitle());
            conditions.put(conditionName, true);
        }
    }
}
