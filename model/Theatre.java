package model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String theaterId;
    private final String name;
    private final String location;
    private final List<Screen> screens;
    private final List<Show> shows;  // List of shows in the theatre

    public Theatre(String theaterId, String name, String location, List<Screen> screens) {
        this.theaterId = theaterId;
        this.name = name;
        this.location = location;
        this.screens = screens;
        this.shows = new ArrayList<>();  // Initialize the list of shows
    }

    // Method to add a show to the theatre
    public void addShow(Show show) {
        this.shows.add(show);
    }

    // Method to retrieve all shows in the theatre
    public List<Show> getShows() {
        return shows;
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    public String getId() {
        return theaterId;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theaterId='" + theaterId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", screens=" + screens.size() + " screens" +
                ", shows=" + shows.size() + " shows" +  // Added shows size info
                '}';
    }
}
