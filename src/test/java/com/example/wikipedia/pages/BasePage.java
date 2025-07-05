package com.example.wikipedia.pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.title;
import com.example.wikipedia.services.WindowManager;

import static com.codeborne.selenide.WebDriverRunner.url;


public abstract class BasePage {
    protected final WindowManager windowManager = new WindowManager();
    protected String url;

    // Для страниц с прямым URL
    public BasePage(String url) {
        this.url = url;
    }
    
    // Для страниц, открываемых через взаимодействия
    public BasePage() {
    }

    public String getTitle() {
        return title();
    }

    public BasePage open() {
        Selenide.open(url);
        return this;
    }

    public BasePage open(String given_url) {
        Selenide.open(given_url);
        return this;
    }

    public String getCurrentUrl() {
        return url();
    }
}