package com.example.wikipedia.pages;

import java.time.Duration;

import com.codeborne.selenide.SelenideElement;

import com.example.wikipedia.elements.ArticleTitleElement;
import com.example.wikipedia.elements.FollowButton;
import com.example.wikipedia.elements.InteractiveElement;
import com.example.wikipedia.elements.GalleryCloseButton;
import com.example.wikipedia.elements.LanguageSwitchButton;
import com.example.wikipedia.elements.ArticleSection;
import com.example.wikipedia.elements.ShortUrlButton;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


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
    private final SelenideElement referencesHeader = $x("//h2[contains(., 'Ссылки')]");
    private final SelenideElement referencesListContainer =
            $x("//h2[contains(., 'Ссылки')]//following::ul[1]");

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
        referencesHeader.scrollTo();
    }

    public boolean referencesSectionHasLinks() {
        return referencesListContainer.exists() &&
                referencesListContainer.$$("a").size() > 0;
    }

    public void clickFirstReferenceLink() {
        referencesListContainer.$$("a")
                .filterBy(visible)
                .first()
                .click();
    }
}