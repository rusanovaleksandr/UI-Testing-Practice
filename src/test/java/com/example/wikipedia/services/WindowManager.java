package com.example.wikipedia.services;

import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Класс для управления окнами и прокруткой страниц.
 * Содержит методы для выполнения действий, связанных с прокруткой
 * страницы до определенных элементов.
 */
public class WindowManager {
    
    /**
     * Прокручивает страницу до нижней части, где находится блок языков.
     * Если блок языков не найден, прокручивает страницу до самого низа.
     */
    public void scrollToFooter() {
        executeJavaScript("""
            const langBlock = document.querySelector('#p-lang, .interlanguage-list');
            if (langBlock) {
                langBlock.scrollIntoView({behavior: 'smooth', block: 'end'});
            } else {
                window.scrollTo(0, document.body.scrollHeight);
            }
            """);
    }
}
