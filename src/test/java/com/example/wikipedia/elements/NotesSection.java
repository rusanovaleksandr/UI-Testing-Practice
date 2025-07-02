package com.example.wikipedia.elements;

import com.example.wikipedia.core.BaseElement;

public class NotesSection extends BaseElement {
    public NotesSection() {
        super("#Примечания");
    }
    
    public boolean exists() {
        return element.exists();
    }
}