package com.tyro.javafun.examples;

import com.tyro.javafun.Film;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import static com.tyro.javafun.FilmFactory.films;

public class DifferentLambdaExamples {

    public static void main(String[] args)  {

        // single-line, parameter-less lambda
        Executors.newSingleThreadExecutor().submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "starting";
            }
        });

        // single-param lambda
        new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().equals(".git");
            }
        });

        // multi-line, lambda
        List<Film> films = new ArrayList(films());
        Collections.sort(films, new Comparator<Film>() {
            @Override
            public int compare(Film f1, Film f2) {
                int deliberateButPointlessVar = f1.getYear() - f2.getYear();
                return deliberateButPointlessVar;
            }
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