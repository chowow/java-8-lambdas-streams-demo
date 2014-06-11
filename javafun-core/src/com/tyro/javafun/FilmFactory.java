package com.tyro.javafun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmFactory {

    private static Set<Film> films;

    static {
        try {
            // TODO relative path
//            films = Files.lines(Paths.get("/Users/chrisandzoe/Dropbox/chris/IdeaProjects/javafun/films.csv"))
            films = Files.lines(Paths.get("C:\\Users\\Chris\\Dropbox\\chris\\IdeaProjects\\javafun\\films.csv"))
                    .map(l -> l.split("\t"))
                    .map(sa -> Film.builder()
                            .withTitle(sa[0])
                            .withYear(sa[1])
                            .withRating(sa[2])
                            .withGenres(sa.length < 5 ? new String[]{"Unknown"} : sa[4].split(","))
                            .build())
                    .filter(f -> !f.getTitle().contains("\"")) // TV shows are in quotes
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static Set<Film> films() {
        return films;
    }

    public static Film randomFilm() {
        return (Film) films.toArray()[new Random().nextInt(films.size())];
    }

    public static void main(String[] args) {
        films().stream()
                .sorted((f1, f2) -> f1.getTitle().compareTo(f2.getTitle()))
                .forEach(System.out::println);
    }
}
