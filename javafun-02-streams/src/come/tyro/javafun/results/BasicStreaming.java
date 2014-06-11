package come.tyro.javafun.results;

import com.tyro.javafun.Film;

import static com.tyro.javafun.FilmFactory.films;

public class BasicStreaming {

    public static void main(String[] args) {

        System.out.println(films().stream()
                .filter(f -> f.getGenres().contains("Comedy"))
                .filter(f -> f.getYear() >= 1990 && f.getYear() <= 1999)
                .filter(f -> f.getRating() > 8)
                .map(Film::getTitle)
                .reduce((f1, f2) -> f1 + ", " + f2)
                .orElse("None found"));
    }
}
