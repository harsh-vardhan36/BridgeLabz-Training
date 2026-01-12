package com.scenariobased.texteditor;

class Action {
    String type;   
    String text;
    int position;

    Action(String type, String text, int position) {
        this.type = type;
        this.text = text;
        this.position = position;
    }
}
