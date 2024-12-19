package api;

import model.Booking;
import model.Seat;
import model.Show;
import model.User;
import services.BookingService;
import services.ShowService;
import services.TheatreService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private final ShowService showService;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    // Constructor
    public BookingController(ShowService showService, BookingService bookingService, TheatreService theatreService) {
        this.showService = showService;
        this.bookingService = bookingService;
        this.theatreService = theatreService;
    }

    public String createBooking(final User userId, final String showId, final List<String> seatIds) {
        Show show = showService.getShow(showId);
        List<Seat> seats = seatIds.stream()
                                  .map(seatId -> theatreService.getSeat(seatId))
                                  .collect(Collectors.toList());
        Booking booking = bookingService.createBooking(show, userId, seats);
        return booking.getId();
    }
}
