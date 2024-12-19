package services;

import exceptions.NotFoundException;
import exceptions.ScreenAlreadyOccupiedException;
import model.Movie;
import model.Screen;
import model.Show;

import java.util.*;

public class ShowService {

    private final Map<String, Show> shows;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show getShow(final String showId) {
        if (!shows.containsKey(showId)) {
            throw new NotFoundException("Show not found with ID: " + showId);
        }
        return shows.get(showId);
    }

    public Show createShow(final Movie movie, final Screen screen, final Date startTime, final Integer durationInSeconds) {
        if (!checkIfShowCreationAllowed(screen, startTime, durationInSeconds)) {
            throw new ScreenAlreadyOccupiedException("Screen already occupied during this time slot.");
        }
        String showId = UUID.randomUUID().toString();
        final Show show = new Show(showId, movie, screen, startTime, durationInSeconds, null);
        this.shows.put(showId, show);
        return show;
    }

    public List<Show> getShowsForScreen(final Screen screen) {
        final List<Show> response = new ArrayList<>();
        for (Show show : shows.values()) {
            if (show.getScreen().equals(screen)) {
                response.add(show);
            }
        }
        return response;
    }

    private boolean checkIfShowCreationAllowed(final Screen screen, final Date startTime, final Integer durationInSeconds) {
        List<Show> existingShows = getShowsForScreen(screen);
        Date newShowEndTime = new Date(startTime.getTime() + durationInSeconds * 1000L);

        for (Show show : existingShows) {
            Date existingStartTime = show.getStartTime();
            Date existingEndTime = new Date(existingStartTime.getTime() + show.getDurationInSeconds() * 1000L);

            if (startTime.before(existingEndTime) && newShowEndTime.after(existingStartTime)) {
                return false; // Overlap detected
            }
        }
        return true; // No overlap
    }
}
