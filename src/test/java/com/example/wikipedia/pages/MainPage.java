package com.example.wikipedia.pages;

import com.example.wikipedia.elements.RandomPageButton;
import com.example.wikipedia.elements.SearchElement;
import com.example.wikipedia.elements.UserIcon;

import com.example.wikipedia.elements.LoginButton;
import com.example.wikipedia.elements.LogoutButton;

public class MainPage extends BasePage {
    private final RandomPageButton randomPageButton = RandomPageButton.byTitle("Посмотреть случайно выбранную страницу");
    private final SearchElement searchElement = SearchElement.byClass("vector-search-box-input");
    private final LoginButton loginButton = LoginButton.byId("pt-login");
    private final LogoutButton logoutButton = LogoutButton.byId("pt-logout");
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