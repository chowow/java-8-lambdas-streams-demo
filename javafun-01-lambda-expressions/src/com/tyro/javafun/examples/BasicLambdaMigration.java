package com.tyro.javafun.examples;

import com.tyro.javafun.Film;
import com.tyro.javafun.FilmFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicLambdaMigration {

    public static void main(String[] args) {
        List<Film> films = new ArrayList(FilmFactory.films());

        Collections.sort(films, new Comparator<Film>() {
            @Override
            public int compare(Film f1, Film f2) {
                return f1.getTitle().compareTo(f2.getTitle());
            }
        });

        for (Film film : films) {
            System.out.println(film.getTitle());
        }
    }
}
