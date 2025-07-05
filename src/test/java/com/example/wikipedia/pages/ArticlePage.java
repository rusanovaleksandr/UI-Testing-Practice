/*package com.example.wikipedia.pages;

import java.time.Duration;

import com.codeborne.selenide.SelenideElement;
import com.example.wikipedia.elements.ArticleImagesElement;
import com.example.wikipedia.elements.ArticleTitleElement;
import com.example.wikipedia.elements.CiteButton;
import com.example.wikipedia.elements.FollowButton;
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
    public final FollowButton followButton = FollowButton.byDefault();

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

    public CitationPage clickCiteButton() {
        citeButton.click();
        return new CitationPage();
    }


    public void scrollToReferencesSection() {
        referencesSection.scrollTo();
    }

    public boolean referencesSectionHasLinks() {
        return referencesSection.hasLinks();
    }

    public boolean referencesSectionHasVisibleLinks() {
        return referencesSection.hasVisibleLinks();
    }

    public void clickFirstReferenceLink() {
        referencesSection.clickFirstVisibleLink();
    }
}*/
package com.example.wikipedia.pages;

import java.time.Duration;

import com.example.wikipedia.elements.*;

public class ArticlePage extends BasePage {
    private final ArticleTitleElement titleElement = ArticleTitleElement.byId("firstHeading");
    private final LanguageSwitchButton englishButton = LanguageSwitchButton.byLangValue("en");
    private final InteractiveElement pdfButton = InteractiveElement.byId("coll-download-as-rl");
    private final ShortUrlButton shortUrlButton = ShortUrlButton.byId("t-urlshortener");
    private final ArticleSection referencesSection = ArticleSection.byId("Ссылки");
    private final ArticleSection notesSection = ArticleSection.byId("Примечания");
    private final InteractiveElement citeButton = InteractiveElement.byId("t-cite");
    private final FollowButton followButton = FollowButton.byIds("ca-watch", "ca-unwatch");
    private final GalleryCloseButton galleryCloseButton = GalleryCloseButton.byTitle("Закрыть этот инструмент (Esc)");
    private final InteractiveElement infoboxImage =  InteractiveElement.bySelector("td.infobox-image img");
    private final ReferencesSection referenceSection = ReferencesSection.byId("Ссылки");

    public String getArticleTitle() {
        return titleElement.getText();
    }

    public void openShortUrlDialogWindow()
    {
        shortUrlButton.click();
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
        galleryCloseButton.click(Duration.ofSeconds(3));
    }

    public boolean isGalleryVisible(){
        return galleryCloseButton.exists();
    }

    public CitationPage clickCiteButton() {
        citeButton.click();
        return new CitationPage();
    }

    public void scrollToReferencesSection() {
        referenceSection.scrollTo();
    }

    public boolean referencesSectionHasLinks() {
        return referenceSection.hasLinks();
    }

    public boolean referencesSectionHasVisibleLinks() {
        return referenceSection.hasVisibleLinks();
    }

    public void clickFirstReferenceLink() {
        referenceSection.clickFirstVisibleLink();
    }

}