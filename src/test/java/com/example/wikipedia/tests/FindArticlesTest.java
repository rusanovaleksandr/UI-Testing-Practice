package com.example.wikipedia.tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestResults;


public class FindArticlesTest extends BaseTest {
    private static final int MAX_ATTEMPTS = 10;
    private static final String TEST_HAS_IMAGE = "test4_has_image";
    private static final String TEST_SHORT_URL = "test5_short_url";
    private static final String TEST_HAS_TITLE = "test6_has_title";
    private static final String TEST_HAS_CITE = "test7_has_cite";
    private static final String TEST_HAS_REFERENCES = "test8_has_references";
    private static final String TEST_HAS_NOTES = "test9_has_notes";
    private static final String TEST_HAS_ENGLISH = "test10_has_english";
    private static final String TEST_HAS_PDF = "test11_has_pdf";
    
    @Test
    void findArticlesWithConditions() {
        Map<String, Boolean> conditions = new HashMap<>() {{
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
            checkAndUpdateCondition(conditions, article, TEST_HAS_IMAGE, article.hasImages());
            checkAndUpdateCondition(conditions, article, TEST_SHORT_URL, article.hasShortUrlOption());
            checkAndUpdateCondition(conditions, article, TEST_HAS_TITLE,true);
            checkAndUpdateCondition(conditions, article, TEST_HAS_CITE, article.hasCiteOption());
            checkAndUpdateCondition(conditions, article, TEST_HAS_REFERENCES, article.hasReferencesSection());
            checkAndUpdateCondition(conditions, article, TEST_HAS_NOTES, article.hasNotesSection());
            checkAndUpdateCondition(conditions, article, TEST_HAS_ENGLISH, article.hasEnglishVersion());
            checkAndUpdateCondition(conditions, article, TEST_HAS_PDF, article.hasPdfDownload());      
        }
        
        conditions.forEach((testName, found) -> {
            if (!found) {
                TestResults.addResult(testName, "Не найдено за " + MAX_ATTEMPTS + " попыток");
            }
        });
    }

    private void checkAndUpdateCondition(Map<String, Boolean> conditions, ArticlePage article, 
                                       String conditionName, boolean conditionMet) {
        if (!conditions.get(conditionName) && conditionMet) {
            TestResults.addResult(conditionName, article.getArticleTitle());
            conditions.put(conditionName, true);
        }
    }

}
