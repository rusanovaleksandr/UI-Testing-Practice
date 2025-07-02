package com.example.wikipedia.pages;

import com.example.wikipedia.core.BasePage;
import com.example.wikipedia.elements.CiteButton;
import com.example.wikipedia.elements.LanguageSwitchButton;
import com.example.wikipedia.elements.NotesSection;
import com.example.wikipedia.elements.PdfDownloadButton;
import com.example.wikipedia.elements.ReferencesSection;
import com.example.wikipedia.elements.ShortUrlButton;
import com.example.wikipedia.elements.ArticleTitleElement;
import com.example.wikipedia.elements.ArticleImagesElement;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;

import org.openqa.selenium.Keys;


public class ArticlePage extends BasePage {
    private final ArticleTitleElement titleElement = new ArticleTitleElement();
    private final ArticleImagesElement imagesElement = new ArticleImagesElement();
    private final LanguageSwitchButton englishButton = new LanguageSwitchButton();
    private final PdfDownloadButton pdfButton = new PdfDownloadButton();
    private final CiteButton citeButton = new CiteButton();
    private final ShortUrlButton shortUrlButton = new ShortUrlButton();
    private final ReferencesSection referencesSection = new ReferencesSection();
    private final NotesSection notesSection = new NotesSection();

    public String getArticleTitle() {
        return titleElement.getText();
    }

    public ArticlePage openShortUrlInNewTab(String url) {
        windowManager.openInNewTab(url);
        windowManager.switchToTab(1);
        titleElement.isDisplayed(Duration.ofSeconds(3));
        
        return new ArticlePage();
    }
    
    public void closeCurrentTabAndSwitchToOriginal() {
        windowManager.closeCurrentTab();
        windowManager.switchToTab(0);
    }

    public void closeShortUrlDialog() {
        actions().sendKeys(Keys.ESCAPE).perform();
    }

    public String getShortUrl(){
        shortUrlButton.clickAndOpenDialog();
        return shortUrlButton.getShortUrlFromDialog();
    }

    public boolean hasImages() {
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