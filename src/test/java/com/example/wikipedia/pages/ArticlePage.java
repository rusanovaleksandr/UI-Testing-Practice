package com.example.wikipedia.pages;

import com.example.wikipedia.elements.CiteButton;
import com.example.wikipedia.elements.LanguageSwitchButton;
import com.example.wikipedia.elements.NotesSection;
import com.example.wikipedia.elements.PdfDownloadButton;
import com.example.wikipedia.elements.ReferencesSection;
import com.example.wikipedia.elements.ShortUrlButton;
import com.example.wikipedia.elements.ArticleTitleElement;
import com.example.wikipedia.elements.ArticleImagesElement;
import java.time.Duration;



public class ArticlePage extends BasePage {
    private final ArticleTitleElement titleElement = ArticleTitleElement.byDefault();
    private final LanguageSwitchButton englishButton = LanguageSwitchButton.byDefault();
    private final PdfDownloadButton pdfButton = PdfDownloadButton.byDefault();
    private final ShortUrlButton shortUrlButton = ShortUrlButton.byDefault();
    private final ReferencesSection referencesSection = ReferencesSection.byDefault();
    private final NotesSection notesSection = NotesSection.byDefault();

    public String getArticleTitle() {
        return titleElement.getText();
    }

    public ArticlePage openShortUrlInNewTab(String url) {
        windowManager.openInNewTab(url);
        windowManager.switchToTab(1);
        titleElement.isDisplayed(Duration.ofSeconds(3));
        return new ArticlePage();
    }

    public String getShortUrl(){
        shortUrlButton.clickAndOpenDialog();
        return shortUrlButton.getShortUrlFromDialog();
    }

    public boolean hasImages() {
        ArticleImagesElement imagesElement = ArticleImagesElement.byDefault();
        return imagesElement.hasImages();
    }

    public boolean hasEnglishVersion() {
        scrollToFooter();
        return englishButton.isDisplayed(Duration.ofSeconds(3));
    }
    
    private void scrollToFooter() {
        windowManager.scrollToFooter();
    }

    public boolean hasPdfDownload() {
        return pdfButton.isAvailable();
    }

    public boolean hasCiteOption() {
        CiteButton citeButton = CiteButton.byDefault();
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