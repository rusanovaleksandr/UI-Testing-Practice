package com.example.wikipedia.elements;

public class NotesSection extends BaseElement {
    public NotesSection() {
        super("#Примечания");
    }
    
    public boolean exists() {
        return element.exists();
    }
}