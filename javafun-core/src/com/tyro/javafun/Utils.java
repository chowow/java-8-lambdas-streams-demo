package com.tyro.javafun;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Utils {

    public static void printDivider(final String label) {
        System.out.println();
        label.chars().mapToObj(c -> "-").forEach(System.out::print);
        System.out.println("----");
        System.out.println("- " + label + " -");
        label.chars().mapToObj(c -> "-").forEach(System.out::print);
        System.out.println("----");
        System.out.println();
    }

    public static List<Integer> createIntList(int collectionSize) {
        List<Integer> someIntegers = new ArrayList<>(collectionSize);
        for (int i = 0; i < collectionSize; i++) {
            someIntegers.add(i);
        }
        return someIntegers;
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public static <T> T sleep(int millis, T returnVal) {
        sleep(millis);
        return returnVal;
    }
}

