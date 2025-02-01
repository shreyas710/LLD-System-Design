import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityMovies;
    List<Movie> allMovies;

    MovieController() {
        cityMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    void addMovie(Movie movie, City city) {
        allMovies.add(movie);

        List<Movie> movies = cityMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMovies.put(city, movies);
    }

    Movie getMovieByName(String name) {
        for (Movie movie : allMovies) {
            if(movie.getMovieName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMoviesByCity(City city) {
        return cityMovies.get(city);
    }
}
