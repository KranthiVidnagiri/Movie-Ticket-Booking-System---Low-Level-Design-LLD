package model;

import java.util.Date;

public class SeatLock {
    private Seat seat;
    private Show show;
    private int timeoutInSeconds;
    private Date lockTime;
    private String lockedBy;

    // Constructor
    public SeatLock(Seat seat, Show show, int timeoutInSeconds, Date lockTime, String lockedBy) {
        this.seat = seat;
        this.show = show;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockTime = lockTime;
        this.lockedBy = lockedBy;
    }

    // Getters
    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public int getTimeoutInSeconds() {
        return timeoutInSeconds;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    // Check if the lock is expired
    public boolean isLockExpired() {
        long elapsed = new Date().getTime() - lockTime.getTime();
        return elapsed > timeoutInSeconds * 1000;
    }
}
