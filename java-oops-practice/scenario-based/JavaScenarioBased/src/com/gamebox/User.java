package com.gamebox;

import java.util.*;

class User {
    private String name;
    private List<Game> ownedGames = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void buyGame(Game game) {
        ownedGames.add(game);
        System.out.println(name + " bought " + game.title);
    }

    public void showLibrary() {
        System.out.println( name + "'s Game Library:");
        for (Game g : ownedGames) {
            System.out.println(g.title + " (" + g.genre + ")");
        }
    }
}
