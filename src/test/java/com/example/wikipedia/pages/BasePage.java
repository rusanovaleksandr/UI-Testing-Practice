package com.example.wikipedia.pages;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.example.wikipedia.services.WindowManager;

/**
 * Абстрактный класс, представляющий базовую страницу в приложении.
 * Содержит общие методы и свойства, которые могут использоваться
 * на всех страницах приложения.
 */
public abstract class BasePage {
    protected final WindowManager windowManager = new WindowManager();
    protected String url;

    /**
     * Конструктор для создания базовой страницы с указанным URL.
     *
     * @param url строка, представляющая URL страницы
     */
    public BasePage(String url) {
        this.url = url;
    }
    
    /**
     * Конструктор для создания базовой страницы без указания URL.
     * Используется для создания страниц, где URL будет установлен позже.
     */
    public BasePage() {
    }

    /**
     * Получает заголовок текущей страницы.
     *
     * @return строка, представляющая заголовок страницы
     */
    public String getTitle() {
        return title();
    }

    /**
     * Получает текущий URL страницы.
     *
     * @return строка, представляющая текущий URL
     */
    public String getCurrentUrl() {
        return url();
    }
}
