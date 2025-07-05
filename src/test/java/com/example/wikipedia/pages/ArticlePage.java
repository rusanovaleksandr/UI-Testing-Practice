package com.example.wikipedia.pages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.wikipedia.elements.ArticleSection;
import com.example.wikipedia.elements.ArticleTitleElement;
import com.example.wikipedia.elements.FollowButton;
import com.example.wikipedia.elements.FootnoteElement;
import com.example.wikipedia.elements.GalleryCloseButton;
import com.example.wikipedia.elements.InteractiveElement;
import com.example.wikipedia.elements.LanguageSwitchButton;
import com.example.wikipedia.elements.ShortUrlButton;

/**
 * Класс, представляющий страницу статьи в Wikipedia.
 * Содержит методы для взаимодействия с различными элементами страницы статьи:
 * заголовком, разделами, кнопками управления и другими компонентами.
 */
public class ArticlePage extends BasePage {
    // Элементы страницы
    private final ArticleTitleElement titleElement = ArticleTitleElement.byId("firstHeading");
    private final LanguageSwitchButton englishButton = LanguageSwitchButton.byLangValue("en");
    private final InteractiveElement pdfButton = InteractiveElement.byId("coll-download-as-rl");
    private final ShortUrlButton shortUrlButton = ShortUrlButton.byId("t-urlshortener");
    private final ArticleSection referencesSection = ArticleSection.byId("Ссылки");
    private final ArticleSection notesSection = ArticleSection.byId("Примечания");
    private final InteractiveElement citeButton = InteractiveElement.byId("t-cite");
    private final FollowButton followButton = FollowButton.byIds("ca-watch", "ca-unwatch");
    private final GalleryCloseButton galleryCloseButton = GalleryCloseButton.byTitle("Закрыть этот инструмент (Esc)");
    private final InteractiveElement infoboxImage = InteractiveElement.bySelector("td.infobox-image img");
    
    private final SelenideElement referencesHeader = $x("//h2[contains(., 'Ссылки')]");
    private final SelenideElement referencesListContainer =
            $x("//h2[contains(., 'Ссылки')]//following::ul[1]");
    private final InteractiveElement backToTextButton = InteractiveElement.byTitle("Обратно к тексту");
    private final FootnoteElement footnote = FootnoteElement.byFootnoteNumber("1");

    /**
     * Получает заголовок статьи.
     *
     * @return текст заголовка статьи
     */
    public String getArticleTitle() {
        return titleElement.getText();
    }

    /**
     * Открывает диалоговое окно для получения короткой ссылки.
     */
    public void openShortUrlDialogWindow() {
        shortUrlButton.click();
    }

    /**
     * Получает короткую ссылку из диалогового окна.
     *
     * @return короткую ссылку на статью
     */
    public String getShortUrlFromDialogWindow() {
        return shortUrlButton.getShortUrlFromDialog();
    }

    /**
     * Проверяет наличие изображений в статье.
     *
     * @return true если изображения присутствуют, false в противном случае
     */
    public boolean hasImages() {
        return infoboxImage.exists();
    }

    /**
     * Проверяет наличие английской версии статьи.
     *
     * @return true если английская версия доступна, false в противном случае
     */
    public boolean hasEnglishVersion() {
        return englishButton.isDisplayed(Duration.ofSeconds(3));
    }

    /**
     * Проверяет наличие кнопки подписки на статью.
     *
     * @return true если кнопка подписки отображается, false в противном случае
     */
    public boolean hasFollowButton() {
        return followButton.isDisplayed();
    }
    
    /**
     * Прокручивает страницу к подвалу.
     */
    public void scrollToFooter() {
        windowManager.scrollToFooter();
    }

    /**
     * Проверяет возможность скачивания статьи в PDF формате.
     *
     * @return true если PDF версия доступна, false в противном случае
     */
    public boolean hasPdfDownload() {
        return pdfButton.isAvailable();
    }

    /**
     * Проверяет наличие опции цитирования статьи.
     *
     * @return true если опция цитирования доступна, false в противном случае
     */
    public boolean hasCiteOption() {
        return citeButton.isAvailable();
    }

    /**
     * Проверяет наличие опции получения короткой ссылки.
     *
     * @return true если опция доступна, false в противном случае
     */
    public boolean hasShortUrlOption() {
        return shortUrlButton.isAvailable();
    }
    
    /**
     * Проверяет наличие раздела "Ссылки" в статье.
     *
     * @return true если раздел существует, false в противном случае
     */
    public boolean hasReferencesSection() {
        return referencesSection.exists();
    }

    /**
     * Проверяет наличие раздела "Примечания" в статье.
     *
     * @return true если раздел существует, false в противном случае
     */
    public boolean hasNotesSection() {
        return notesSection.exists();
    }

    /**
     * Проверяет, подписан ли пользователь на статью.
     *
     * @return true если пользователь подписан, false в противном случае
     */
    public boolean isArticleWatched() {
        return followButton.isActive();
    }

    /**
     * Переключает состояние подписки на статью.
     */
    public void toggleFollowButton() {
        followButton.click();
    }

    /**
     * Ожидает появления кнопки подписки.
     */
    public void waitUntilWatchButtonIsVisible() {
        followButton.watchButtonShouldBeVisible();
    }

    /**
     * Ожидает появления кнопки отписки.
     */
    public void waitUntilUnwatchButtonIsVisible() {
        followButton.unwatchButtonShouldBeVisible();
    }

    /**
     * Открывает галерею изображений.
     */
    public void openGallery() {
        infoboxImage.click();
    }

    /**
     * Ожидает открытия галереи изображений.
     */
    public void waitUntilGalleryIsOpened() {
        galleryCloseButton.waitUntilOpened();
    }

    /**
     * Закрывает галерею изображений.
     */
    public void closeGallery() {
        galleryCloseButton.click(Duration.ofSeconds(3));
    }

    /**
     * Проверяет видимость галереи изображений.
     *
     * @return true если галерея видима, false в противном случае
     */
    public boolean isGalleryVisible() {
        return galleryCloseButton.exists();
    }

    /**
     * Переходит по короткой ссылке.
     *
     * @param shortUrl короткая ссылка для перехода
     * @return текущий экземпляр ArticlePage
     */
    public ArticlePage followShortUrl(String shortUrl) {
        WebDriverRunner.getWebDriver().navigate().to(shortUrl);
        return this;
    }

    /**
     * Переключает статью на английскую версию.
     *
     * @return новый экземпляр ArticlePage для английской версии
     */
    public ArticlePage switchToEnglish() {
        englishButton.click();
        return new ArticlePage();
    }

    /**
     * Проверяет наличие английского шаблона на странице.
     *
     * @return текст подзаголовка сайта
     */
    public String hasEnglishTemplate() {
        return $x("//div[@id='siteSub']")
                .shouldBe(visible, Duration.ofSeconds(5))
                .getText();
    }

    /**
     * Кликает по сноске в тексте статьи.
     */
    public void clickFootnote() {
        footnote.click();
    }

    /**
     * Проверяет видимость кнопки возврата к тексту.
     *
     * @return true если кнопка видима, false в противном случае
     */
    public boolean isBackToTextButtonVisible() {
        return backToTextButton.isDisplayed();
    }

    /**
     * Кликает по кнопке возврата к тексту.
     */
    public void clickBackToTextButton() {
        backToTextButton.click();
    }

    /**
     * Проверяет, содержит ли URL указанный якорь.
     *
     * @param anchor якорь для проверки
     * @return true если URL содержит якорь, false в противном случае
     */
    public boolean urlContainsAnchor(String anchor) {
        return getCurrentUrl().contains(anchor);
    }

    /**
     * Открывает страницу скачивания PDF версии статьи.
     *
     * @return экземпляр PdfDownloadPage
     */
    public PdfDownloadPage openPdfDownload() {
        pdfButton.click();
        return new PdfDownloadPage();
    }
    
    /**
     * Открывает страницу цитирования статьи.
     *
     * @return экземпляр CitationPage
     */
    public CitationPage clickCiteButton() {
        citeButton.click();
        return new CitationPage();
    }

    /**
     * Прокручивает страницу к разделу "Ссылки".
     */
    public void scrollToReferencesSection() {
        referencesHeader.scrollTo();
    }

    /**
     * Проверяет наличие ссылок в разделе "Ссылки".
     *
     * @return true если ссылки присутствуют, false в противном случае
     */
    public boolean referencesSectionHasLinks() {
        return referencesListContainer.exists() &&
                referencesListContainer.$$("a").size() > 0;
    }

    /**
     * Кликает по первой доступной ссылке в разделе "Ссылки".
     */
    public void clickFirstReferenceLink() {
        referencesListContainer.$$("a")
                .filterBy(visible)
                .first()
                .click();
    }
}