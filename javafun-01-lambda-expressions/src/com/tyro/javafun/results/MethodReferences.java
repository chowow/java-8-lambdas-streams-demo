package com.tyro.javafun.results;

import com.tyro.javafun.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tyro.javafun.FilmFactory.films;

public class MethodReferences {

    public static void main(String[] args) {
        List<Film> films = new ArrayList<>(films());

        // can be replaced with method reference:
        Collections.sort(films, Film::compareTitles);

        //films.forEach(System.out::println);

        // More examples:
        //films.forEach(MethodReferences::printTitle);
        //films.forEach(Film::printTitle);
    }

    public static void printTitle(Film f) {
        System.out.println(f.getTitle());
    }
}

