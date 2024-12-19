package services;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private Map<String, Theatre> theatres = new HashMap<>();
    private Map<String, Screen> screens = new HashMap<>();
    private Map<String, Seat> seats = new HashMap<>();

    public Theatre createTheatre(String name, String location) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, name, location, new ArrayList<>());
        theatres.put(theatreId, theatre);
        return theatre;
    }

    public Screen createScreenInTheatre(String screenName, String screenType, Theatre theatre) {
        Screen screen = new Screen(UUID.randomUUID().toString(), screenName, screenType, theatre);
        theatre.addScreen(screen);
        screens.put(screen.getId(), screen);  // Save screen in the screens map
        return screen;
    }

    public Seat createSeatInScreen(Integer rowNo, Integer seatNo, SeatType seatType, double price, Screen screen) {
        Seat seat = new Seat(UUID.randomUUID().toString(), rowNo, seatNo, seatType, price);
        screen.addSeat(seat);
        seats.put(seat.getId(), seat);  // Save seat in the seats map
        return seat;
    }

    // Method to retrieve a Theatre by its ID
    public Theatre getTheatre(String theatreId) {
        return theatres.get(theatreId);  // Retrieve the theatre from the map
    }

    // Method to retrieve a Screen by its ID
    public Screen getScreen(String screenId) {
        return screens.get(screenId);  // Retrieve the screen from the map
    }

    // Method to retrieve a Seat by its ID
    public Seat getSeat(String seatId) {
        return seats.get(seatId);  // Retrieve the seat from the map
    }

    // Modify existing code to add Show to the Theatre
    public void addShowToTheatre(Theatre theatre, Show show) {
        if (theatre != null && show != null) {
            theatre.getShows().add(show);  // Assuming Theatre has a getShows() method
        } else {
            throw new IllegalArgumentException("Theatre or Show cannot be null.");
        }
    }
}
