package com.songvault;

public class Media<T> {
    protected String title;
    protected String artist;
    protected T duration;
    protected String genre;

    public Media(String title, String artist, T duration, String genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}

