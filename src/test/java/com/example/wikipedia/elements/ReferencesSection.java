package com.example.wikipedia.elements;

import com.example.wikipedia.core.BaseElement;

public class ReferencesSection extends BaseElement {
    public ReferencesSection() {
        super("#Ссылки");
        //super("h2:has(span[id='Ссылки']), h2:has(span[id='References'])");
    }

    public boolean exists() {
        return element.exists();
    }
    
    // Дополнительные методы, если нужны
    public int getReferencesCount() {
        return element.$$x("./following-sibling::div[1]//li").size();
    }
}