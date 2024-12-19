package services;

import exceptions.NotFoundException;
import model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {

    private final Map<String, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    // Get a Movie by ID
    public Movie getMovie(final String movieId) {
        if (!movies.containsKey(movieId)) {
            throw new NotFoundException("Movie with ID " + movieId + " not found.");
        }
        return movies.get(movieId);
    }

    // Create a new Movie
    public Movie createMovie(final String movieName) {
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId, movieName);
        movies.put(movieId, movie);
        return movie;
    }

    // Remove a Movie by ID
    public void removeMovie(final String movieId) {
        if (!movies.containsKey(movieId)) {
            throw new NotFoundException("Movie with ID " + movieId + " does not exist.");
        }
        movies.remove(movieId);
    }

    // List all Movies
    public Map<String, Movie> listAllMovies() {
        return new HashMap<>(movies);
    }
}
