package com.example.wikipedia.pages;

import com.codeborne.selenide.Selenide;
import com.example.wikipedia.services.WindowManager;

import static com.codeborne.selenide.Selenide.title;

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

    public void open() {
        Selenide.open(url);
    }

    public void open(String given_url) {
        Selenide.open(given_url);
    }

    public String getTitle() {
        return title();
    }
}