package come.tyro.javafun.results;

import com.tyro.javafun.Film;

import static com.tyro.javafun.FilmFactory.films;

public class TheBestFilmEverUsingTypedStreams {

    public static void main(String[] args) {

        System.out.println("best film(s) ever: ");

        films().stream()
                .filter(f -> f.getRating() == (
                        films().stream()
                                .mapToDouble(Film::getRating)
                                .max()
                                .orElse(0.0)))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("worst film(s) ever: ");

        films().stream()
                .filter(f -> f.getRating() == (
                        films().stream()
                                .mapToDouble(Film::getRating)
                                .min()
                                .orElse(0.0)))
                .forEach(System.out::println);
    }
}
