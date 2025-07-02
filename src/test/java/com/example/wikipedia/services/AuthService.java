package com.example.wikipedia.services;

import io.github.cdimascio.dotenv.Dotenv;
import com.example.wikipedia.pages.MainPage;
import com.example.wikipedia.pages.LoginPage;

public class AuthService {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String LOGIN = dotenv.get("WIKIPEDIA_LOGIN");

    public static MainPage login() {
        MainPage mainPage = MainPage.byDefault();
        mainPage.open();
        
        // Если уже авторизованы, пропускаем вход
        if (mainPage.isLoggedIn(LOGIN)) {
            return mainPage;
        }
        
        // Если нет — выполняем вход
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.enterLogin(LOGIN)
                .enterPassword(dotenv.get("WIKIPEDIA_PASSWORD"))
                .submit();
        
        return mainPage;
    }
}