package come.tyro.javafun.results;

import com.tyro.javafun.Film;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.tyro.javafun.FilmFactory.films;

public class BasicStreamingTidyUp {

    private static final Function<String, Predicate<Film>> genre = g -> f -> f.getGenres().contains(g);
    private static final BiFunction<Integer, Integer, Predicate<Film>> between = (y1, y2) -> f -> f.getYear() >= y1 && f.getYear() <= y2;

    public static void main(String[] args) {

        System.out.println(films().stream()
                .filter(genre.apply("Comedy"))
                .filter(between.apply(1990, 1999))
                .filter(f -> f.getRating() > 8)
                .map(Film::getTitle)
                .sorted()     // can optionally pass a comparator lambda
                .collect(Collectors.joining(", ")));
        // sucks there's no optional
    }
}
