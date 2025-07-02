package com.example.wikipedia.tests;

import org.junit.jupiter.api.Test;

import com.example.wikipedia.services.TestResults;

import java.util.HashMap;
import java.util.Map;

import com.example.wikipedia.core.BaseTest;
import com.example.wikipedia.pages.*;


public class FindArticlesTest extends BaseTest {
    private static final int MAX_ATTEMPTS = 10;
    
    @Test
    void findArticlesWithConditions() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        
        Map<String, Boolean> conditions = new HashMap<>() {{
            put("test4_has_image", false);
            put("test5_short_url", false);
            put("test6_has_title", false);
            put("test7_has_cite", false);
            put("test8_has_references", false);
            put("test9_has_notes", false);
            put("test10_has_english", false);
            put("test11_has_pdf", false);
        }};
        
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            if (!conditions.containsValue(false)) break;

            ArticlePage article = mainPage.openRandomArticle();
            
            checkAndUpdateCondition(conditions, article, "test4_has_image", article.hasImages());

            checkAndUpdateCondition(conditions, article, "test5_short_url", article.hasShortUrlOption());

            checkAndUpdateCondition(conditions, article, "test6_has_title",true);

            checkAndUpdateCondition(conditions, article, "test7_has_cite", article.hasCiteOption());

            checkAndUpdateCondition(conditions, article, "test8_has_references", article.hasReferencesSection());

            checkAndUpdateCondition(conditions, article, "test9_has_notes", article.hasNotesSection());

            checkAndUpdateCondition(conditions, article, "test10_has_english", article.hasEnglishVersion());

            checkAndUpdateCondition(conditions, article, "test11_has_pdf", article.hasPdfDownload());      

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
