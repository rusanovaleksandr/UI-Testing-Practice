package com.example.wikipedia.pages;

import java.time.Duration;
import com.example.wikipedia.elements.ArticleTitleElement;
import com.example.wikipedia.elements.CiteButton;
import com.example.wikipedia.elements.FollowButton;
import com.example.wikipedia.elements.GalleryCloseButton;
import com.example.wikipedia.elements.LanguageSwitchButton;
import com.example.wikipedia.elements.NotesSection;
import com.example.wikipedia.elements.PdfDownloadButton;
import com.example.wikipedia.elements.ReferencesSection;
import com.example.wikipedia.elements.ShortUrlButton;
import com.example.wikipedia.elements.InfoboxImage;

public class ArticlePage extends BasePage {
    private final ArticleTitleElement titleElement = ArticleTitleElement.byId("firstHeading");
    private final LanguageSwitchButton englishButton = LanguageSwitchButton.byLangValue("en");
    private final PdfDownloadButton pdfButton = PdfDownloadButton.byId("coll-download-as-rl");
    private final ShortUrlButton shortUrlButton = ShortUrlButton.byId("t-urlshortener");
    private final ReferencesSection referencesSection = ReferencesSection.byId("Ссылки");
    private final NotesSection notesSection = NotesSection.byId("Примечания");
    private final CiteButton citeButton = CiteButton.byId("t-cite");
    private final FollowButton followButton = FollowButton.byIds("ca-watch", "ca-unwatch");
    private final GalleryCloseButton galleryCloseButton = GalleryCloseButton.byTitle("Закрыть этот инструмент (Esc)");
    private final InfoboxImage infoboxImage = InfoboxImage.byParentClass("infobox-image");

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
        return infoboxImage.exists();
    }

    public boolean hasEnglishVersion() {
        return englishButton.isDisplayed(Duration.ofSeconds(3));
    }

    public boolean hasFollowButton(){
        return followButton.isDisplayed();
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

    public boolean isArticleWatched() {
        return followButton.isActive();
    }

    public void toggleFollowButton() {
        followButton.click();
    }

    public void waitUntilWatchButtonIsVisible(){
        followButton.watchButtonShouldBeVisible();
    }

    public void waitUntilUnwatchButtonIsVisible(){
        followButton.unwatchButtonShouldBeVisible();
    }

    public void openGallery(){
        infoboxImage.click();
    }

    public void waitUntilGalleryIsOpened(){
        galleryCloseButton.waitUntilOpened();
    }

    public void closeGallery(){
        galleryCloseButton.clickAndWaitUntilClosed();
    }

    public boolean isGalleryVisible(){
        return galleryCloseButton.exists();
    }
    
}