package com.example.wikipedia.pages;

import com.example.wikipedia.elements.DownloadButton;

import java.io.File;

public class PdfDownloadPage extends BasePage {
    private final DownloadButton downloadButton = DownloadButton.byText("Скачать");


    public File downloadPdf() {
        return downloadButton.downloadPdf();
    }
}
