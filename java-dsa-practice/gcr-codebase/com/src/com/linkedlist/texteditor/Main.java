package com.linkedlist.texteditor;

public class Main {
    public static void main(String[] args) {

        UndoRedoManager editor = new UndoRedoManager();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! Java");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello World! Java DSA");
        editor.displayCurrentState();
    }
}
