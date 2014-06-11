package com.tyro.javafun;

import java.util.Arrays;
import java.util.Random;

import static com.tyro.javafun.FilmFactory.films;
import static com.tyro.javafun.Utils.printDivider;

public class StreamBonusFeatures {

    public static void main(String[] args) {

        printDivider("Strings are streams too");

        "Example1".chars().forEach(c -> System.out.println((char) c));

        printDivider("Flat map allows collections (as streams) to be combined");

        films().stream()
                .flatMap(f -> f.getGenres().stream())
                .sorted()
                .distinct()
                .forEach(System.out::println);


        printDivider("Arrays to streams");

        Arrays.stream(new double[] {3.4, 4.5, -1.3})
                .sorted()
                .forEach(System.out::println);

        printDivider("Random stream");

        new Random().ints()
                .filter(i -> i < 2 && i > -2)
                .forEach(System.out::println);
                // will never terminate!
    }
}
