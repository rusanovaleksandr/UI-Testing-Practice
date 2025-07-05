package com.example.wikipedia.elements;

import static java.time.Duration.ofSeconds;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Класс, представляющий кнопку подписки/отписки на странице.
 * Наследует функциональность ClickableElement и предоставляет методы для работы
 * с кнопками подписки и проверки их состояния.
 */
public class FollowButton extends ClickableElement {
    /** 
     * XPath шаблон для поиска элемента по двум возможным ID 
     */
    private static final String TWO_IDS_XPATH = "//*[@id='%s' or @id='%s']";
    
    /** CSS селектор кнопки подписки */
    private final String watch_button_selector;
    
    /** CSS селектор кнопки отписки */
    private final String unwatch_button_selector;
    
    /**
     * Конструктор для создания кнопки подписки/отписки.
     *
     * @param watch_id ID элемента кнопки подписки
     * @param unwatch_id ID элемента кнопки отписки
     * @param xpath флаг, указывающий на использование XPath локатора
     */
    public FollowButton(String watch_id, String unwatch_id, boolean xpath) {
        super(String.format(TWO_IDS_XPATH, watch_id, unwatch_id), xpath);
        this.watch_button_selector = String.format("#%s", watch_id);
        this.unwatch_button_selector = String.format("#%s", unwatch_id);
    }

    /**
     * Проверяет, активна ли подписка (отображается ли кнопка отписки).
     *
     * @return true если кнопка отписки присутствует на странице, false в противном случае
     */
    public boolean isActive() {
        return $(unwatch_button_selector).exists();
    }

    /**
     * Проверяет, что кнопка отписки отображается в течение 3 секунд.
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не становится видимым
     */
    public void unwatchButtonShouldBeVisible() {
        $(unwatch_button_selector).shouldBe(visible, ofSeconds(3));
    }

    /**
     * Проверяет, что кнопка подписки отображается в течение 3 секунд.
     * @throws com.codeborne.selenide.ex.ElementNotFound если элемент не становится видимым
     */
    public void watchButtonShouldBeVisible() {
        $(watch_button_selector).is(visible, ofSeconds(3));
    }

    /**
     * Фабричный метод для создания FollowButton по ID кнопок.
     *
     * @param watch_id ID кнопки подписки
     * @param unwatch_id ID кнопки отписки
     * @return новый экземпляр FollowButton
     */
    public static FollowButton byIds(String watch_id, String unwatch_id) {
        return new FollowButton(watch_id, unwatch_id, true);
    }
}