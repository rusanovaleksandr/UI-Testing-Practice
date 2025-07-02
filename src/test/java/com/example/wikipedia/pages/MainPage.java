package com.example.wikipedia.pages;

import com.example.wikipedia.elements.RandomPageButton;
import com.example.wikipedia.elements.SearchElement;

public class MainPage extends BasePage {
    private final RandomPageButton randomPageButton = RandomPageButton.byDefault();
    private final SearchElement searchElement = SearchElement.byDefault();

    public MainPage() {
        super("https://ru.wikipedia.org/wiki/Главная_страница");
    }

    public ArticlePage openRandomArticle() {
        randomPageButton.click();
        return new ArticlePage();
    }
    
    public ArticlePage openArticle(String articleName) {
        searchElement.search(articleName);
        return new ArticlePage();
    }

    public static MainPage byDefault() {
        return new MainPage();
    }
    
}