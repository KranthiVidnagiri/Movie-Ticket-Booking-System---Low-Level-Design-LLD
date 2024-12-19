package model;

import java.util.List;

public class Booking {
    private final String id;
    private final Show show;
    private final List<Seat> seatsBooked;
    private final User user;
    private BookingStatus bookingStatus;

    public Booking(String id, Show show, User user, List<Seat> seatsBooked) {
        this.id = id;
        this.show = show;
        this.user = user;
        this.seatsBooked = seatsBooked;
        this.bookingStatus = BookingStatus.CREATED;
    }

    // Booking Status Methods
    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new IllegalStateException("Cannot confirm booking. Invalid state.");
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new IllegalStateException("Cannot expire booking. Invalid state.");
        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }

    public String getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public User getUser() {
        return user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    
}
