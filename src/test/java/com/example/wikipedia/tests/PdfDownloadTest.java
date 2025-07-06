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

/**
 * Тестовый класс для проверки загрузки статей в формате PDF.
 * Проверяет наличие функционала скачивания, корректность процесса загрузки
 * и валидность полученного PDF-файла.
 */
public class PdfDownloadTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test11_has_pdf";

    /**
     * Тестирует процесс скачивания статьи в формате PDF.
     * Проверяет наличие кнопки скачивания, факт загрузки файла,
     * его размер и валидность формата.
     */
    @Test
    void shouldDownloadPdfCorrectly() {
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Название статьи не загружено");        ArticlePage articlePage = mainPage.openArticle(articleName);
        assertTrue(articlePage.hasPdfDownload(), "Нет кнопки Скачать как PDF");
        PdfDownloadPage pdfDownloadPage = articlePage.openPdfDownload();
        File downloadedFile = pdfDownloadPage.downloadPdf();
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