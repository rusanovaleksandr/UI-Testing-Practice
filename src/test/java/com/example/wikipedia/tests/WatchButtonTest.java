package com.example.wikipedia.tests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.services.TestDataLoader;

public class WatchButtonTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test2_has_follow";

    @Test
    void shouldToggleWatchStatus() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Не удалось загрузить название статьи из тестовых данных");
        ArticlePage articlePage = mainPage.openArticle(articleName);
        boolean wasActive = articlePage.isArticleWatched();
        articlePage.toggleFollowButton();
        if(wasActive){
            articlePage.waitUntilWatchButtonIsVisible();
        } else{
            articlePage.waitUntilUnwatchButtonIsVisible();
        }

        assertNotEquals(wasActive, articlePage.isArticleWatched());
    }
}