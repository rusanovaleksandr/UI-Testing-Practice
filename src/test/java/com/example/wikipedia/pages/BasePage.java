package com.example.wikipedia.pages;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.example.wikipedia.services.WindowManager;


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

    public String getCurrentUrl() {
        return url();
    }
}