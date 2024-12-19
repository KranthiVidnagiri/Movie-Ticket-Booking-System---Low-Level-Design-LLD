package api;

import model.Movie;
import model.Screen;
import model.Seat;
import model.Show;
import services.MovieService;
import services.SeatAvailabilityService;
import services.ShowService;
import services.TheatreService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShowController {
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;
    private final SeatAvailabilityService seatAvailabilityService;

    // Constructor
    public ShowController(ShowService showService, TheatreService theatreService, MovieService movieService, SeatAvailabilityService seatAvailabilityService) {
        this.showService = showService;
        this.theatreService = theatreService;
        this.movieService = movieService;
        this.seatAvailabilityService = seatAvailabilityService;
    }

    public String createShow(final String movieId, final String screenId, final Date startTime, final Integer durationInSeconds) {
        Screen screen = theatreService.getScreen(screenId);
        Movie movie = movieService.getMovie(movieId);
        Show show = showService.createShow(movie, screen, startTime, durationInSeconds);
        return show.getId();
    }

    public List<String> getAvailableSeats(final String showId) {
        Show show = showService.getShow(showId);
        List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}
