package model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String id;
    private String name;
    private String screenType;
    private Theatre theatre;
    private List<Seat> seats;

    public Screen(String id, String name, String screenType, Theatre theatre) {
        this.id = id;
        this.name = name;
        this.screenType = screenType;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "screenId='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + getSeats().size() +
                ", screenType='" + screenType + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
}
