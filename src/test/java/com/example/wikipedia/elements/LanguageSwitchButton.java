package com.example.wikipedia.elements;

/**
 * Класс, представляющий кнопку переключения языка на веб-странице.
 * Наследует функциональность InteractiveElement и предоставляет специализированные
 * методы для работы с языковыми переключателями.
 */
public class LanguageSwitchButton extends InteractiveElement {
    /**
     * XPath шаблон для поиска элементов по атрибуту lang
     */
    private static final String LANG_XPATH = "//*[@lang='%s' and contains(@class,'interlanguage-link-target')]";

    /**
     * Конструктор для создания кнопки переключения языка.
     *
     * @param selector строка селектора для поиска элемента
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public LanguageSwitchButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Фабричный метод для создания кнопки переключения языка по значению атрибута lang.
     *
     * @param lang_value значение атрибута lang (код языка)
     * @return новый экземпляр LanguageSwitchButton
     * @throws IllegalArgumentException если переданное значение lang_value равно null или пустое
     */
    public static LanguageSwitchButton byLangValue(String lang_value) {
        if (lang_value == null || lang_value.trim().isEmpty()) {
            throw new IllegalArgumentException("Language value cannot be null or empty");
        }
        return new LanguageSwitchButton(String.format(LANG_XPATH, lang_value), true);
    }
}