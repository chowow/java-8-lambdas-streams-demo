package com.tyro.javafun.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tyro.javafun.Utils.createIntList;
import static com.tyro.javafun.Utils.printDivider;
import static com.tyro.javafun.Utils.sleep;
import static java.lang.System.currentTimeMillis;

public class BasicParallelStreams {

    public static void main(String[] args) {

        // old skool
        printDivider("iterating");

        long start = currentTimeMillis();
        List<Double> result = iterator_sqRtEvenNumbers(createIntList(1_000));
        long end = currentTimeMillis() - start;

        System.out.println(result);
        System.out.println("took: " + end + "ms");


        // nu streams
        printDivider("streaming");

        start = currentTimeMillis();
        List<Double> resultWithStreams = stream_sqRtEvenNumbers(createIntList(1_000));
        end = currentTimeMillis() - start;


        System.out.println(resultWithStreams);
        System.out.println("took: " + end + "ms\n");
        System.out.println(result.equals(resultWithStreams) ? "result was the same" : "results differed");
    }

    private static List<Double> iterator_sqRtEvenNumbers(List<Integer> source) {
        List<Double> result = new ArrayList<>();
        for (Integer i : source) {
            if (i % 2 == 0) {
                result.add(Math.sqrt(i));
                sleep(10);
            }
        }
        return result;
    }

    private static List<Double> stream_sqRtEvenNumbers(List<Integer> source) {
        return source.stream()
                .filter(i -> i % 2 == 0)
                .map(Math::sqrt)
                .map(i -> sleep(10, i))
                .collect(Collectors.toList());
    }
}
