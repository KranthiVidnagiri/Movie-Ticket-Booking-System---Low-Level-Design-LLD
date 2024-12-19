package providers;

import model.Seat;
import model.Show;
import java.util.List;
import java.util.ArrayList;

public class SeatLockProviderImpl implements SeatLockProvider {

    private final List<Seat> lockedSeats = new ArrayList<>();

    @Override
    public void lockSeats(Show show, List<Seat> seats, String user, int lockTimeoutInSeconds) {
        // Implement the logic to lock the seats for the user
        for (Seat seat : seats) {
            // Lock the seat and add it to lockedSeats list
            lockedSeats.add(seat);
            System.out.println("Locked seat: " + seat.getSeatId() + " for user: " + user);
        }

        // You can also implement timeout handling if needed (using lockTimeoutInSeconds)
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, String user) {
        // Implement the logic to unlock the seats
        lockedSeats.removeAll(seats);
        for (Seat seat : seats) {
            System.out.println("Unlocked seat: " + seat.getSeatId() + " for user: " + user);
        }
    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        // Check if a seat is locked
        return lockedSeats.contains(seat);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        return new ArrayList<>(lockedSeats);
    }
}
