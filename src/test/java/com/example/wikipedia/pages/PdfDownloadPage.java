package com.example.wikipedia.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class PdfDownloadPage extends BasePage {
    private final SelenideElement downloadButton = $x("//button[.//span[text()='Скачать']]");

    public File downloadPdf() {
        // Возвращаем File объект напрямую из Selenide
        return downloadButton.download();
    }
}
