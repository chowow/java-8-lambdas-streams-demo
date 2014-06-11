package com.tyro.javafun.results;

import com.tyro.javafun.Film;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

import static com.tyro.javafun.FilmFactory.films;

public class DifferentLambdaExamples {

    public static void main(String[] args) {

        // single-line, parameterless lambda
        Executors.newSingleThreadExecutor().submit(() -> "starting");

        // single-param lambda
        new File(".").listFiles(file -> file.getName().equals(".git"));

        // multi-line, lambda
        List<Film> films = new ArrayList(films());
        Collections.sort(films, (f1, f2) -> {
            int deliberateButPointlessVar = f1.getYear() - f2.getYear();
            return deliberateButPointlessVar;
        });


        // must have only one method
        someOtherMethod(new NotASingleAbstractMethodInterface() {
            @Override
            public void doStuff() {
                System.out.println("doing stuff");
            }

            @Override
            public void doOtherStuff() {
                System.out.println("doing other stuff");
            }
        });
    }

    public static void someOtherMethod(NotASingleAbstractMethodInterface param) {
        System.out.println("done");
    }

    public interface NotASingleAbstractMethodInterface {
        public void doStuff();
        public void doOtherStuff();
    }

}