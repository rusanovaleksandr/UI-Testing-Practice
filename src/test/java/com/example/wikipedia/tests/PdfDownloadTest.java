package com.example.wikipedia.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.example.wikipedia.pages.ArticlePage;
import com.example.wikipedia.pages.PdfDownloadPage;
import com.example.wikipedia.services.TestDataLoader;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PdfDownloadTest extends BaseTest {
    private static final String TEST_ARTICLE_KEY = "test11_has_pdf";
    private static final String DOWNLOAD_DIR = "target/downloads";

    @Test
    void shouldDownloadPdfCorrectly() throws Exception {
        // Подготовка тестовых данных
        String articleName = TestDataLoader.getTestArticle(TEST_ARTICLE_KEY);
        assertNotNull(articleName, "Название статьи не загружено");

        // Открываем главную страницу и переходим в статью
        ArticlePage articlelPage = mainPage.openArticle(articleName);
        ArticlePage articlePage = mainPage.openRandomArticle();

        assertTrue(articlePage.hasPdfDownload(), "Нет кнопки Скачать как PDF");

        // Запоминаем текущее окно
        String mainWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        // Открываем страницу экспорта PDF (откроется новое окно/вкладка)
        // Открываем страницу экспорта PDF
        PdfDownloadPage pdfDownloadPage = articlePage.openPdfDownload();

        // Нажимаем кнопку "Скачать"
        File downloadedFile = pdfDownloadPage.downloadPdf();

        // Проверки
        assertNotNull(downloadedFile, "Файл не загружен");
        assertTrue(downloadedFile.exists(), "Файл не существует");
        assertTrue(downloadedFile.length() > 0, "Файл пустой");
        assertTrue(isPdfValid(downloadedFile), "Невалидный PDF");

        // Очистка
        downloadedFile.delete();
    }

    private File waitForFileDownload(String dir, String fileName, int timeoutSec) throws InterruptedException {
        File file = new File(dir, fileName);
        int attempts = 0;
        while (attempts++ < timeoutSec) {
            if (file.exists() && file.length() > 0) {
                return file;
            }
            Thread.sleep(1000);
        }
        return null;
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