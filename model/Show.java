package model;

import java.util.Date;
import java.util.Map;

public class Show {
    private final String id;
    private Movie movie;
    private Screen screen;
    private final Date startTime;
    private final long durationInSeconds;
    private Map<SeatType, Double> priceMap;

    public Show(String id, Movie movie, Screen screen, Date startTime, long durationInSeconds, Map<SeatType, Double> priceMap) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.durationInSeconds = durationInSeconds;
        this.priceMap = priceMap;
    }


    @Override
    public String toString() {
        return "Show{" +
                "showId='" + id + '\'' +
                ", movie=" + movie.getTitle() +
                ", startTime=" + startTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    public Map<SeatType, Double> getPriceMap() {
        return priceMap;
    }
}
