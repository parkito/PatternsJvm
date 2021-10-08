package com.siksmfp.behavioral.momento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextWindowStateTest {

    @Test
    void givenTextEditor_whenAddTextSaveAddMoreAndUndo_thenSaveStateRestored() {
        TextEditor textEditor = new TextEditor(new TextWindow());

        textEditor.write("The Memento Design Pattern\n");
        textEditor.write("How to implement it in Java?\n");
        textEditor.hitSave();
        textEditor.write("Buy milk and eggs before coming home\n");
        textEditor.hitUndo();

        assertEquals(textEditor.print(), "The Memento Design Pattern\nHow to implement it in Java?\n");
    }
}