package com.example.wikipedia.pages;

import com.example.wikipedia.elements.RandomPageButton;
import com.example.wikipedia.elements.SearchElement;

public class MainPage extends BasePage {
    private final RandomPageButton randomPageButton;
    private final SearchElement searchElement;

    public MainPage() {
        super("https://ru.wikipedia.org/wiki/Главная_страница");
        this.randomPageButton = new RandomPageButton();
        this.searchElement = new SearchElement();
    }

    public ArticlePage openRandomArticle() {
        randomPageButton.click();
        return new ArticlePage();
    }
    
    // Основной метод поиска (просто выполняет поиск)
    public void searchForArticle(String articleName) {
        searchElement.search(articleName);
    }
    
    // Полный цикл: поиск + открытие статьи
    public ArticlePage openArticle(String articleName) {
        searchForArticle(articleName);
        return new ArticlePage(); // После нажатия Enter попадаем прямо на статью
    }
    
}