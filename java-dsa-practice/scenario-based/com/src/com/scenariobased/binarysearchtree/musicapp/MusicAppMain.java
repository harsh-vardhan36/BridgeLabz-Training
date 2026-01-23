package com.scenariobased.binarysearchtree.musicapp;

public class MusicAppMain {

    public static void main(String[] args) {

        MusicBST library = new MusicBST();

        // Insert songs
        library.insert(201, "Believer", "Imagine Dragons");
        library.insert(105, "Alone", "Alan Walker");
        library.insert(330, "Shape of You", "Ed Sheeran");
        library.insert(410, "Closer", "The Chainsmokers");
        library.insert(150, "Faded", "Alan Walker");

        // Search by Track ID
        System.out.println("Searching track ID 330:");
        SongNode song = library.searchByTrackId(330);
        if (song != null)
            System.out.println("Found: " + song.title + " by " + song.artist);
        else
            System.out.println("Song not found");

        // Alphabetical Playlist
        System.out.println("\nPlaylist (Alphabetical Order):");
        library.inorderPlaylist();
    }
}
