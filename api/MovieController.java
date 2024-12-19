package api;

import model.Movie;
import services.MovieService;

public class MovieController {
    private final MovieService movieService;

    // Constructor
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String createMovie(final String movieName) {
        Movie movie = movieService.createMovie(movieName);
        return movie.getId();
    }
}
