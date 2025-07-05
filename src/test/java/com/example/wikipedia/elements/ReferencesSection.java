package com.example.wikipedia.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ReferencesSection extends ScrollableElement {
    public static final String DEFAULT_SELECTOR = "#Ссылки";

    private final SelenideElement referencesHeader = $x("//h2[contains(., 'Ссылки')]");
    private final SelenideElement referencesListContainer =
            $x("//h2[contains(., 'Ссылки')]//following::ul[1]");

    public ReferencesSection(String selector) {
        super(selector);
    }

    public static ReferencesSection byDefault() {
        return new ReferencesSection(DEFAULT_SELECTOR);
    }

    public void scrollTo() {
        referencesHeader.scrollTo();
    }

    public boolean isDisplayed() {
        return referencesHeader.isDisplayed();
    }

    public boolean hasLinks() {
        return referencesListContainer.exists() &&
                referencesListContainer.$$("a").size() > 0;
    }

    public boolean hasVisibleLinks() {
        return referencesListContainer.exists() &&
                referencesListContainer.$$("a").filterBy(visible).size() > 0;
    }

    public void clickFirstVisibleLink() {
        referencesListContainer.$$("a")
                .filterBy(visible)
                .first()
                .click();
    }

    public void clickFirstLink() {
        element.$("a").click();
    }

    public ReferencesSection(String locator, boolean isXpath) {
        super(locator, isXpath);
    }

    public static ReferencesSection byId(String id) {
        return new ReferencesSection(String.format(ID_XPATH, id), true);
    }

}