/*package com.example.wikipedia.tests;

import com.example.wikipedia.pages.ArticlePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CiteButtonTest extends BaseTest {
    private static final String ARTICLE_NAME = "test7_has_cite";

    @Test
    void testCitationModalAppearance() {
        // 1. Открыть заглавную страницу (уже выполнено в BaseTest)
        // 2. Ввести значение в поиск и нажать кнопку "Поиск"
        ArticlePage articlePage = mainPage.openArticle(ARTICLE_NAME);

        // 3. Нажать кнопку «Цитировать страницу»
        var citeModal = articlePage.openCitationModal();

        // Проверки ожидаемого результата
        assertTrue(citeModal.isVisible(), "Модальное окно не отображается");
        assertTrue(citeModal.hasCitationContent(), "Отсутствует содержимое цитирования");

        // Проверка нескольких форматов
        String[] expectedFormats = {"APA", "MLA", "Chicago"};
        for (String format : expectedFormats) {
            assertTrue(
                    citeModal.hasCitationFormat(format),
                    "Не найден формат: " + format
            );
        }
    }
}*/
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
        assertEquals("Библиографические ссылки на статью", citationPage.getCitationHeadingText());
    }
}