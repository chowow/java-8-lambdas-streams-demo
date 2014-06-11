package come.tyro.javafun.examples;

import com.tyro.javafun.Film;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.tyro.javafun.FilmFactory.films;
import static java.lang.String.format;

public class GroupingDataWithCollectors {

    private static final Function<String, Predicate<Film>> genre = g -> f -> f.getGenres().contains(g);

    public static void main(String[] args) {

//        Map<Integer, List<Film>> worstHorrorFilmsByYear = films().stream()
//                .filter(genre.apply("Horror"))
//                .filter(f -> f.getRating() < 4)
//                .???
//
//          worstHorrorFilmsByYear.forEach((y, fl) -> System.out.println(format("%d [%d]: %s", y, fl.size(), fl)));

    }
}
