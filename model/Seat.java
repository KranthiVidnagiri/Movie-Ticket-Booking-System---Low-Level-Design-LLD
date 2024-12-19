package model;

public class Seat {
    private final String id; // Correct field name
    private int rowNo;
    private int seatNo;
    private SeatType seatType;
    private double price;

    // Constructor with all attributes
    public Seat(String id, int rowNo, int seatNo, SeatType seatType, double price) {
        this.id = id;
        this.rowNo = rowNo;
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.price = price;
    }

    // Constructor for Seat creation with only seatId
    public Seat(String seatId) {
        this.id = seatId; // Ensure consistency in field names
    }

    // Getter for seatId (field is 'id', so method is getId)
    public String getId() {
        return id;
    }

    public String getSeatId() {
        return id; // Ensure consistency
    }

    @Override
    public String toString() {
        return "Seat{" + "seatId='" + id + '\'' + '}'; // Ensure consistency with 'id'
    }
}
