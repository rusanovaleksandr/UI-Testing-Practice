package com.example.wikipedia.pages;

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
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


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
    private final SelenideElement referencesHeader = $x("//h2[contains(., 'Ссылки')]");
    private final SelenideElement referencesListContainer =
            $x("//h2[contains(., 'Ссылки')]//following::ul[1]");
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