package com.tyro.javafun.examples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.tyro.javafun.Utils.createIntList;
import static com.tyro.javafun.Utils.printDivider;

public class CountingThreads {

    public static void main(String[] args) {

        printDivider("single-threaded");
        printThreadCounts(countThreads(1_000_000, Collection::stream));

        // how can we control the number of threads?
        // System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
        // ... or with a custom ForkJoinPool

        printDivider("multi-threaded");
        System.out.println("expected number of threads " + Runtime.getRuntime().availableProcessors() + "\n");
        printThreadCounts(countThreads(1_000_000, Collection::parallelStream));
    }

    private static Map<String, Integer> countThreads(int collectionSize, Function<Collection<?>, Stream<?>> streamFn) {
        Map<String, Integer> threadUsage = new HashMap<>();
        streamFn.apply(createIntList(collectionSize))
                .collect(Collectors.groupingBy(i -> Thread.currentThread().getName()))
                .forEach((t, l) -> threadUsage.put((String) t, l.size()));
        return threadUsage;
    }

    private static void printThreadCounts(Map<String, Integer> threadsUsed) {
        threadsUsed.forEach((t, c) -> System.out.println(t + ":\t" + c));
    }
}
