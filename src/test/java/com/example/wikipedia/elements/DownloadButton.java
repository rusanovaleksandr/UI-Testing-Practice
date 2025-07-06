package com.example.wikipedia.elements;

import java.io.File;

/**
 * Представляет кнопку скачивания на веб-странице.
 * Наследует функциональность {@link BaseElement} и предоставляет методы
 * для взаимодействия с элементами скачивания, включая загрузку PDF-файлов.
 */
public class DownloadButton extends BaseElement {
    private static final String TEXT_XPATH = "//button[.//span[text()='%s']]";

    /**
     * Конструктор для создания кнопки скачивания.
     *
     * @param selector селектор элемента
     * @param xpath флаг, указывающий тип селектора (true - XPath, false - CSS)
     */
    public DownloadButton(String selector, boolean xpath) {
        super(selector, xpath);
    }

    /**
     * Выполняет скачивание PDF-файла.
     *
     * @return скачанный файл в формате PDF
     */
    public File downloadPdf() {
        return element.download();
    }

    /**
     * Фабричный метод для создания кнопки по тексту на ней.
     *
     * @param id текст кнопки
     * @return экземпляр {@link DownloadButton}
     */
    public static DownloadButton byText(String id) {
        return new DownloadButton(String.format(TEXT_XPATH, id), true);
    }

}
