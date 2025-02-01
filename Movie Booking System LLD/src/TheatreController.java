import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityTheatre;
    List<Theatre> allTheatres;

    TheatreController() {
        this.cityTheatre = new HashMap<>();
        this.allTheatres = new ArrayList<Theatre>();
    }

    void addTheatre(Theatre theatre, City city) {
        allTheatres.add(theatre);

        List<Theatre> theatres = cityTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityTheatre.put(city, theatres);
    }

    Map<Theatre, List<Show>> getAllShows(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreShows = new HashMap<>();

        List<Theatre> theatres = cityTheatre.get(city);
        for (Theatre theatre : theatres) {
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for (Show show : shows) {
                if (show.movie.getMovieID() == movie.getMovieID()) {
                    givenMovieShows.add(show);
                }
            }

            if (!givenMovieShows.isEmpty()) {
                theatreShows.put(theatre, givenMovieShows);
            }
        }

        return theatreShows;
    }
}
