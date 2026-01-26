package com.songvault;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        List<Song> songs =
                SongReader.readSongs("songs");

        Map<String, List<Song>> byGenre =
                SongLibrary.groupByGenre(songs);

        System.out.println("Songs by Genre:");
        byGenre.forEach((g, s) ->
                System.out.println(g + " → " + s.size()));

        System.out.println("\nUnique Artists:");
        SongLibrary.uniqueArtists(songs)
                .forEach(System.out::println);

        System.out.println("\nSorted Songs:");
        SongLibrary.sortByTitle(songs)
                .forEach(System.out::println);
    }
}
