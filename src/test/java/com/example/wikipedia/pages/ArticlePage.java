package com.example.wikipedia.pages;

import java.time.Duration;

import com.example.wikipedia.elements.ArticleImagesElement;
import com.example.wikipedia.elements.ArticleTitleElement;
import com.example.wikipedia.elements.CiteButton;
import com.example.wikipedia.elements.LanguageSwitchButton;
import com.example.wikipedia.elements.NotesSection;
import com.example.wikipedia.elements.PdfDownloadButton;
import com.example.wikipedia.elements.ReferencesSection;
import com.example.wikipedia.elements.ShortUrlButton;



public class ArticlePage extends BasePage {
    private final ArticleTitleElement titleElement = ArticleTitleElement.byDefault();
    private final LanguageSwitchButton englishButton = LanguageSwitchButton.byDefault();
    private final PdfDownloadButton pdfButton = PdfDownloadButton.byDefault();
    private final ShortUrlButton shortUrlButton = ShortUrlButton.byDefault();
    private final ReferencesSection referencesSection = ReferencesSection.byDefault();
    private final NotesSection notesSection = NotesSection.byDefault();
    private final CiteButton citeButton = CiteButton.byDefault();
    private final ArticleImagesElement imagesElement = ArticleImagesElement.byDefault();

    public String getArticleTitle() {
        return titleElement.getText();
    }

    public void openShortUrlDialogWindow()
    {
        shortUrlButton.clickAndOpenDialog();
    }

    public String getShortUrlFromDialogWindow(){
        return shortUrlButton.getShortUrlFromDialog();
    }

    public boolean hasImages() {
        return imagesElement.hasImages();
    }

    public boolean hasEnglishVersion() {
        return englishButton.isDisplayed(Duration.ofSeconds(3));
    }
    
    public void scrollToFooter() {
        windowManager.scrollToFooter();
    }

    public boolean hasPdfDownload() {
        return pdfButton.isAvailable();
    }

    public boolean hasCiteOption() {
        return citeButton.isAvailable();
    }

    public boolean hasShortUrlOption() {
        return shortUrlButton.isAvailable();
    }
    
    public void openShortUrlDialog() {
        shortUrlButton.clickAndOpenDialog();
    }

    public boolean hasReferencesSection() {
        return referencesSection.exists();
    }

    public boolean hasNotesSection() {
        return notesSection.exists();
    }
    
}