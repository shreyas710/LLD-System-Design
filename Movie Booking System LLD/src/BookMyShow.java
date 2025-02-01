import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        bookMyShow.createBooking(City.Bangalore, "BAHUBALI");
        bookMyShow.createBooking(City.Bangalore, "BAHUBALI");
    }

    public void initialize() {
        createMovies();
        createTheatres();
    }

    public void createMovies() {
        Movie avengers = new Movie();
        avengers.setMovieID(1);
        avengers.setMovieName("AVENGERS");
        avengers.setDuration(128);

        Movie bahubali = new Movie();
        bahubali.setMovieID(2);
        bahubali.setMovieName("BAHUBALI");
        bahubali.setDuration(180);

        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(bahubali, City.Bangalore);
        movieController.addMovie(avengers, City.Delhi);
        movieController.addMovie(bahubali, City.Delhi);
    }

    public void createTheatres() {
        Movie avengers = movieController.getMovieByName("AVENGERS");
        Movie bahubali = movieController.getMovieByName("BAHUBALI");

        Theatre inox = new Theatre();
        inox.setTheatreId(1);
        inox.setScreens(createScreen());
        inox.setCity(City.Bangalore);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inox.getScreens().get(0), avengers, 8);
        Show inoxEveningShow = createShows(2, inox.getScreens().get(0), bahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inox.setShows(inoxShows);

        Theatre pvr = new Theatre();
        pvr.setTheatreId(2);
        pvr.setScreens(createScreen());
        pvr.setCity(City.Delhi);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvr.getScreens().get(0), avengers, 13);
        Show pvrEveningShow = createShows(4, pvr.getScreens().get(0), bahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvr.setShows(pvrShows);

        theatreController.addTheatre(inox, City.Bangalore);
        theatreController.addTheatre(pvr, City.Delhi);
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen = new Screen();
        screen.setScreenId(1);
        screen.setSeats(createSeats());
        screens.add(screen);

        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        // 1 to 39 SILVER
        for (int i = 0; i < 40; ++i) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        // 40 to 69 GOLD
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //70 to 99 PLATINUM
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }

    private void createBooking(City city, String movieName) {
        // search movie by location
        List<Movie> movies = movieController.getMoviesByCity(city);

        // select movie which user wants to see
        Movie interestedMovie = null;
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                interestedMovie = movie;
            }
        }

        // get all shows of this movie in city
        Map<Theatre, List<Show>> theatreShows = theatreController.getAllShows(interestedMovie, city);

        // select particular show
        Map.Entry<Theatre, List<Show>> entry = theatreShows.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        // select seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeats();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);

            Booking booking = new Booking();
            List<Seat> mySeats = new ArrayList<>();
            for (Seat seat : interestedShow.getScreen().getSeats()) {
                if (seat.getSeatId() == seatNumber) {
                    mySeats.add(seat);
                }
            }
            booking.setBookedSeats(mySeats);
            booking.setShow(interestedShow);
        } else {
            System.out.println("Booked seat " + seatNumber + " already booked");
            return;
        }
        System.out.println("Booked seat " + seatNumber + " booked");
    }
}