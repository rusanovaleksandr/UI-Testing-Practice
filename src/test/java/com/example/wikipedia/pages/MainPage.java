package com.example.wikipedia.pages;

import com.example.wikipedia.elements.InteractiveElement;
import com.example.wikipedia.elements.SearchElement;
import com.example.wikipedia.elements.UserIcon;

/**
 * Класс, представляющий главную страницу приложения.
 * Содержит методы для взаимодействия с элементами главной страницы
 * и выполнения действий, таких как поиск статей и авторизация.
 */
public class MainPage extends BasePage {
    private final InteractiveElement randomPageButton = InteractiveElement.byTitle("Посмотреть случайно выбранную страницу");
    private final SearchElement searchElement = SearchElement.byClass("vector-search-box-input");
    private final InteractiveElement loginButton = InteractiveElement.byId("pt-login");
    private final InteractiveElement logoutButton = InteractiveElement.byId("pt-logout");
    private final UserIcon userIcon = UserIcon.byId("pt-userpage");

    /**
     * Конструктор для создания главной страницы.
     * Вызывает конструктор родительского класса BasePage.
     */
    public MainPage() {
        super();
    }

    /**
     * Открывает случайную статью, нажимая на соответствующую кнопку.
     *
     * @return новый экземпляр ArticlePage, представляющий открытую статью
     */
    public ArticlePage openRandomArticle() {
        randomPageButton.click();
        return new ArticlePage();
    }
    
    /**
     * Открывает статью по указанному имени.
     *
     * @param articleName строка, представляющая имя статьи для поиска
     * @return новый экземпляр ArticlePage, представляющий открытую статью
     */
    public ArticlePage openArticle(String articleName) {
        searchElement.search(articleName);
        return new ArticlePage();
    }

    /**
     * Нажимает на кнопку входа в систему и возвращает экземпляр LoginPage.
     *
     * @return новый экземпляр LoginPage для выполнения входа
     */
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage();
    }

    /**
     * Проверяет, авторизован ли пользователь по указанному имени пользователя.
     *
     * @param username строка, представляющая имя пользователя
     * @return true, если пользователь авторизован, иначе false
     */
    public boolean isLoggedIn(String username) {
        return userIcon.exists()
               && userIcon.getText().contains(username);
    }

    /**
     * Выходит из системы, нажимая на кнопку выхода.
     *
     * @return текущий экземпляр MainPage для цепочки вызовов
     */
    public MainPage logout() {
        logoutButton.click(); 
        return this;
    }

    /**
     * Фабричный метод для создания экземпляра MainPage по умолчанию.
     *
     * @return новый экземпляр MainPage
     */
    public static MainPage byDefault() {
        return new MainPage();
    }
}
