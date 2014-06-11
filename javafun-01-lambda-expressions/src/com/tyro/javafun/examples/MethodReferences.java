package com.tyro.javafun.examples;

import com.tyro.javafun.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tyro.javafun.FilmFactory.films;

public class MethodReferences {

    public static void main(String[] args) {
        List<Film> films = new ArrayList<>(films());

        // can be replaced with method reference:
        Collections.sort(films, (f1, f2) -> f1.getTitle().compareTo(f2.getTitle()));

        for (Film film : films) { // method reference to System.out.println almost works...
            System.out.println(film.getTitle());
        }

        // More examples:
        //films.forEach(Film::printTitle);
        //films.forEach(MethodReferences::printTitle);
    }

    public static void printTitle(Film f) {
        System.out.println(f.getTitle());
    }
}

