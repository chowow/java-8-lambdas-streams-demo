package come.tyro.javafun.examples;

import com.tyro.javafun.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tyro.javafun.FilmFactory.films;

public class BasicStreaming {

    public static void main(String[] args) {

        // Temporary variables to gather results
        // Seems to be more about "how" than "what"
        List<Film> filteredFilms = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        // Looping. So 90s...
        for (Film film : films()) {
            if (film.getGenres().contains("Comedy")
                    && film.getYear() >= 1990
                    && film.getYear() <= 1999
                    && film.getRating() > 8) {
                filteredFilms.add(film);
            }
        }

        // Sort (modify!) the collection after filtering
        Collections.sort(filteredFilms, (f1, f2) -> f1.getTitle().compareTo(f2.getTitle()));

        // Déjà vu
        for (Film film : filteredFilms) {
            result.append(film.getTitle()).append(", ");
        }

        // I feel dirty...
        if (result.length() > 0) {
            System.out.println(result.substring(0,result.length()-2));
        }
    }
}
