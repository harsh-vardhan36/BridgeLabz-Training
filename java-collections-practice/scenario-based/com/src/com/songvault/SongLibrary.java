package com.songvault;

import java.util.*;
import java.util.stream.*;

public class SongLibrary {

    public static Map<String, List<Song>> groupByGenre(List<Song> songs) {
        return songs.stream()
                .collect(Collectors.groupingBy(Song::getGenre));
    }

    public static Set<String> uniqueArtists(List<Song> songs) {
        return songs.stream()
                .map(Song::getArtist)
                .collect(Collectors.toSet());
    }

    public static List<Song> filterByArtist(
            List<Song> songs, String artist) {

        return songs.stream()
                .filter(s -> s.getArtist().equalsIgnoreCase(artist))
                .collect(Collectors.toList());
    }

    public static List<Song> sortByTitle(List<Song> songs) {
        return songs.stream()
                .sorted(Comparator.comparing(Song::getTitle))
                .collect(Collectors.toList());
    }
}
