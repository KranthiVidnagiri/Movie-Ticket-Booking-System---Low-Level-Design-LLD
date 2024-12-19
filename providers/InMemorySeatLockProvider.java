package providers;

import exceptions.SeatTemporaryUnavailableException;
import model.Seat;
import model.SeatLock;
import model.Show;
import model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemorySeatLockProvider implements SeatLockProvider {

    private final Integer lockTimeout;
    private final Map<Show, Map<Seat, SeatLock>> locks;

    public InMemorySeatLockProvider(final Integer lockTimeout) {
        this.locks = new ConcurrentHashMap<>();
        this.lockTimeout = lockTimeout;
    }

    @Override
    public synchronized void lockSeats(final Show show, final List<Seat> seats, final String user, int lockTimeoutInSeconds) {
        for (Seat seat : seats) {
            if (isSeatLocked(show, seat)) {
                throw new SeatTemporaryUnavailableException("Seat " + seat.getId() + " is temporarily unavailable.");
            }
        }

        for (Seat seat : seats) {
            lockSeat(show, seat, user, lockTimeoutInSeconds);
        }
    }

    @Override
    public void unlockSeats(final Show show, final List<Seat> seats, final String user) {
        for (Seat seat : seats) {
            if (validateLock(show, seat, user)) {
                unlockSeat(show, seat);
            }
        }
    }

    @Override
    public boolean validateLock(final Show show, final Seat seat, final String user) {
        return isSeatLocked(show, seat) && locks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(final Show show) {
        if (!locks.containsKey(show)) {
            return Collections.emptyList(); // Use an empty list if no locked seats
        }
        List<Seat> lockedSeats = new ArrayList<>();
        locks.get(show).forEach((seat, lock) -> {
            if (isSeatLocked(show, seat)) {
                lockedSeats.add(seat);
            }
        });
        return lockedSeats;
    }

    private void unlockSeat(final Show show, final Seat seat) {
        locks.computeIfPresent(show, (k, v) -> {
            v.remove(seat);
            return v;
        });
    }

    private void lockSeat(final Show show, final Seat seat, final String user, final Integer timeoutInSeconds) {
        locks.computeIfAbsent(show, k -> new ConcurrentHashMap<>())
                .put(seat, new SeatLock(seat, show, timeoutInSeconds, new Date(), user));
    }

    private boolean isSeatLocked(final Show show, final Seat seat) {
        return locks.containsKey(show) && locks.get(show).containsKey(seat) && !locks.get(show).get(seat).isLockExpired();
    }

    // The following method is removed as it's not needed.
    // @Override
    // public void lockSeats(Show show, List<Seat> seat, User userId, int lockTimeoutInSeconds) {
    //    throw new UnsupportedOperationException("Unimplemented method 'lockSeats'"); 
    // }
}
