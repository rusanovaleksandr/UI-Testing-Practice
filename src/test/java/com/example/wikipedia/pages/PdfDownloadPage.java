package com.example.wikipedia.pages;

import com.example.wikipedia.elements.DownloadButton;

import java.io.File;

/**
 * Представляет страницу скачивания PDF-версии статьи.
 * Наследует функциональность {@link BasePage} и предоставляет методы
 * для скачивания статьи в формате PDF.
 */
public class PdfDownloadPage extends BasePage {
    private final DownloadButton downloadButton = DownloadButton.byText("Скачать");

    /**
     * Выполняет скачивание PDF-файла статьи.
     *
     * @return скачанный PDF-файл
     */
    public File downloadPdf() {
        return downloadButton.downloadPdf();
    }
}
