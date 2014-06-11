package com.tyro.javafun;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Film {

    private final String title;
    private final int year;
    private final double rating;
    private final Set<String> genres;

    private Film(String title, int year, double rating, Set<String> genres) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public int compareTitles(Film other) {
        return title.compareTo(other.getTitle());
    }

    public void printTitle() {
        System.out.println(title);
    }

    @Override
    public String toString() {
        return asList(title, year + "", rating + "", genres.toString()).stream().collect(Collectors.joining(", "));
    }

    public static Film.Builder builder() {
        return new Film.Builder();
    }

    public static class Builder {
        private String title;
        private int year;
        private double rating;
        private Set<String> genres = new HashSet<>();

        private Builder() {}

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withYear(int year) {
            this.year = year;
            return this;
        }

        public Builder withYear(String year) {
            this.year = Integer.parseInt(year);
            return this;
        }

        public Builder withRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder withRating(String rating) {
            this.rating = Double.parseDouble(rating);
            return this;
        }

        public Builder withGenres(Set<String> genres) {
            this.genres = genres;
            return this;
        }

        public Builder withGenres(String[] genres) {
            for (String genre : genres) {
                this.genres.add(genre);
            }
            return this;
        }

        public Builder withGenre(String genre) {
            this.genres.add(genre);
            return this;
        }

        public Film build() {
            return new Film(title, year, rating, genres);
        }
    }
}
