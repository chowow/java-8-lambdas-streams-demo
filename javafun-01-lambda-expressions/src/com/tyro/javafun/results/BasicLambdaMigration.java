package com.tyro.javafun.results;

import com.tyro.javafun.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tyro.javafun.FilmFactory.films;

public class BasicLambdaMigration {

    public static void main(String[] args) {
        // Must wrap films() Set in List for sorting
        List<Film> films = new ArrayList(films());

        // Changes state
        Collections.sort(films, (f1, f2) -> f1.getTitle().compareTo(f2.getTitle()));

        for (Film film : films) {
            System.out.println(film.getTitle());
        }
    }
}
