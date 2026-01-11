package com.scenariobased.browserbuddy;

public class Main {
    public static void main(String[] args) {

        BrowserTab tab = new BrowserTab();
        TabManager manager = new TabManager();

        tab.visit("google.com");
        tab.visit("youtube.com");
        tab.visit("github.com");

        tab.back();       
        tab.back();       
        tab.forward();    

        manager.closeTab(tab);

        BrowserTab restored = manager.reopenTab();
        System.out.println("Current Page: " + restored.getCurrentPage());
    }
}
