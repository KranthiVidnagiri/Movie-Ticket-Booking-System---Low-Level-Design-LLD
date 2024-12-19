package providers;

import model.Seat;
import model.Show;
import model.User;

import java.util.List;

public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seat, String user, int lockTimeoutInSeconds); // Updated to match the implementation signature
    void unlockSeats(Show show, List<Seat> seat, String user);
    boolean validateLock(Show show, Seat seat, String user);

    List<Seat> getLockedSeats(Show show);
}
