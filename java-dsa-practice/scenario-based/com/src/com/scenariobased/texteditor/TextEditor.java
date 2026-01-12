package com.scenariobased.texteditor;

import java.util.Stack;

class TextEditor {

    StringBuilder content = new StringBuilder();

    Stack<Action> undoStack = new Stack<>();
    Stack<Action> redoStack = new Stack<>();

    // Insert text
    void insert(String text, int pos) {
        content.insert(pos, text);
        undoStack.push(new Action("insert", text, pos));
        redoStack.clear();   
    }

    // Delete text
    void delete(int pos, int length) {
        String removed = content.substring(pos, pos + length);
        content.delete(pos, pos + length);
        undoStack.push(new Action("delete", removed, pos));
        redoStack.clear();
    }

    // Undo
    void undo() {
        if (undoStack.isEmpty()) return;

        Action a = undoStack.pop();

        if (a.type.equals("insert")) {
            content.delete(a.position, a.position + a.text.length());
        } else { 
            content.insert(a.position, a.text);
        }

        redoStack.push(a);
    }

    // Redo
    void redo() {
        if (redoStack.isEmpty()) return;

        Action a = redoStack.pop();

        if (a.type.equals("insert")) {
            content.insert(a.position, a.text);
        } else {
            content.delete(a.position, a.position + a.text.length());
        }

        undoStack.push(a);
    }

    void show() {
        System.out.println(content);
    }
}
