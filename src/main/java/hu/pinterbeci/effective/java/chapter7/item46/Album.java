package hu.pinterbeci.effective.java.chapter7.item46;

import com.google.auto.value.AutoValue;

import java.util.Objects;

@AutoValue
public record Album(String artist, String title, int year, long sales, String genre) {
    public Album(String artist, String title, int year, long sales, String genre) {
        this.artist = Objects.requireNonNull(artist, "artist");
        this.title = Objects.requireNonNull(title, "title");
        this.year = year;
        this.sales = sales;
        this.genre = genre;
    }
}