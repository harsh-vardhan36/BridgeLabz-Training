package com.scenariobased.texteditor;

public class Main {
    public static void main(String[] args) {
        TextEditor t = new TextEditor();

        t.insert("Hello", 0);
        t.insert(" World", 5);
        t.show();         

        t.undo();
        t.show();          

        t.redo();
        t.show();          
        t.delete(5, 6);
        t.show();         

        t.undo();
        t.show();          
    }
}
