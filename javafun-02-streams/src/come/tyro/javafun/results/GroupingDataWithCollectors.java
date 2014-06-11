package come.tyro.javafun.results;

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

        Map<Integer, List<Film>> worstHorrorFilms = films().stream()
                .filter(genre.apply("Horror"))
                .filter(f -> f.getRating() < 4)
                .collect(Collectors.groupingBy(Film::getYear, TreeMap::new, Collectors.toList()));

        // This is odd... collect returns a Map<Integer, List<Film>> without casting, yet if we inline
        // the following it complains about types and seems to be using BiConsumer<Object, Object>.
        // It will also refuse to allow us to cast the lambda parameter fl. Weird...
        worstHorrorFilms.forEach((y, fl) -> System.out.println(format("%d [%d]: %s", y, fl.size(), fl)));
    }
}
