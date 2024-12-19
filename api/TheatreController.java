package api;

import model.Screen;
import model.Seat;
import model.SeatType;
import model.Theatre;
import services.TheatreService;

public class TheatreController {
    private final TheatreService theatreService;

    // Constructor
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String createTheatre(final String theatreName, final String location) {
        Theatre theatre = theatreService.createTheatre(theatreName, location);
        return theatre.getId();
    }

    public String createScreenInTheatre(final String screenName, final String screenType, final String theatreId) {
        Theatre theatre = theatreService.getTheatre(theatreId);
        Screen screen = theatreService.createScreenInTheatre(screenName, screenType, theatre);
        return screen.getId();
    }

    public String createSeatInScreen(final Integer rowNo, final Integer seatNo, final SeatType seatType, final double price, final String screenId) {
        Screen screen = theatreService.getScreen(screenId);
        Seat seat = theatreService.createSeatInScreen(rowNo, seatNo, seatType, price, screen);
        return seat.getId();
    }
}
