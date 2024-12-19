package services;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {

    private Map<String, Booking> bookings = new HashMap<>();

    public Booking createBooking(Show show, User user, List<Seat> seats) {
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, show, user, seats);
        bookings.put(bookingId, booking);
        return booking;
    }

    public void confirmBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.confirmBooking();
        }
    }

    public void expireBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.expireBooking();
        }
    }

    // New method to get the booked seats for a specific show
    public List<Seat> getBookedSeats(Show show) {
        List<Seat> bookedSeats = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getShow().equals(show)) {
                bookedSeats.addAll(booking.getSeatsBooked());  // Using getSeatsBooked() method here
            }
        }
        return bookedSeats;
    }
}
