package com.tyro.javafun.results;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.tyro.javafun.Utils.createIntList;
import static com.tyro.javafun.Utils.printDivider;

public class CountingThreads {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        printDivider("single-threaded");
        printThreadCounts(countThreads(1_000_000, Collection::stream));

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "6");

        printDivider("multi-threaded");
        System.out.println("expected number of threads " + Runtime.getRuntime().availableProcessors() + "\n");
        printThreadCounts(countThreads(1_000_000, Collection::parallelStream));

        printDivider("multi-threaded in custom fork join pool");
        ForkJoinTask<Map<String, Integer>> customPoolTask
                = new ForkJoinPool(4).submit((Callable) () -> countThreads(1_000_000, Collection::parallelStream));
        printThreadCounts(customPoolTask.get());
    }

    private static void printThreadCounts(Map<String, Integer> threadsUsed) {
        threadsUsed.forEach((t, c) -> System.out.println(t + ":\t" + c));
    }

    private static Map<String, Integer> countThreads(int collectionSize, Function<Collection<?>, Stream<?>> streamFn) {
        Map<String, Integer> threadUsage = new HashMap<>();
        streamFn.apply(createIntList(collectionSize))
                .collect(Collectors.groupingBy(i -> Thread.currentThread().getName()))
                .forEach((t, l) -> threadUsage.put((String) t, l.size()));
        return threadUsage;
    }
}
