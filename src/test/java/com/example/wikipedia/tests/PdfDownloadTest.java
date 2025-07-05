package com.example.wikipedia.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.pages.PdfDownloadPage;
import com.example.wikipedia.services.TestDataLoader;

public class PdfDownloadTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test11_has_pdf";

    @Test
    void shouldDownloadPdfCorrectly() {
        // Подготовка тестовых данных
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Название статьи не загружено");

        // Открываем главную страницу и переходим в статью
        ArticlePage articlePage = mainPage.openArticle(articleName);

        assertTrue(articlePage.hasPdfDownload(), "Нет кнопки Скачать как PDF");

        // Открываем страницу экспорта PDF
        PdfDownloadPage pdfDownloadPage = articlePage.openPdfDownload();

        // Нажимаем кнопку "Скачать"
        File downloadedFile = pdfDownloadPage.downloadPdf();

        // Проверки
        assertNotNull(downloadedFile, "Файл не загружен");
        assertTrue(downloadedFile.exists(), "Файл не существует");
        assertTrue(downloadedFile.length() > 0, "Файл пустой");
        assertTrue(isPdfValid(downloadedFile), "Невалидный PDF");

    }

    private boolean isPdfValid(File file) {
        try {
            byte[] content = Files.readAllBytes(file.toPath());
            return content.length > 4 &&
                    new String(content, 0, 4).equals("%PDF");
        } catch (IOException e) {
            return false;
        }
    }
}