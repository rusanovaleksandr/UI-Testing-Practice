package com.example.wikipedia.pages;

import com.example.wikipedia.elements.InteractiveElement;
import com.example.wikipedia.elements.SearchElement;
import com.example.wikipedia.elements.UserIcon;

public class MainPage extends BasePage {
    private final InteractiveElement randomPageButton = InteractiveElement.byTitle("Посмотреть случайно выбранную страницу");
    private final SearchElement searchElement = SearchElement.byClass("vector-search-box-input");
    private final InteractiveElement loginButton = InteractiveElement.byId("pt-login");
    private final InteractiveElement logoutButton = InteractiveElement.byId("pt-logout");
    private final UserIcon userIcon = UserIcon.byId("pt-userpage");

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

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage();
    }

    public boolean isLoggedIn(String username) {
    return userIcon.exists()
           && userIcon.getText().contains(username);
    }

    public MainPage logout() {
        logoutButton.click(); // Нажимаем "Выйти"
        return this;
    }

    public static MainPage byDefault() {
        return new MainPage();
    }
    
}