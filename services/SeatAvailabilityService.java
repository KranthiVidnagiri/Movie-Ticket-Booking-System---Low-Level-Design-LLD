package services;

import model.Seat;
import model.Show;
import providers.SeatLockProvider;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {

    private final BookingService bookingService;
    private final SeatLockProvider seatLockProvider;

    public SeatAvailabilityService(final BookingService bookingService, final SeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(final Show show) {
        final List<Seat> allSeats = show.getScreen().getSeats();
        final List<Seat> unavailableSeats = getUnavailableSeats(show);

        final List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(unavailableSeats);
        return availableSeats;
    }

    private List<Seat> getUnavailableSeats(final Show show) {
        final List<Seat> unavailableSeats = new ArrayList<>(bookingService.getBookedSeats(show));
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats; // Defensive copy ensures immutability
    }
}
