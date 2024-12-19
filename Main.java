import model.*;
import providers.SeatLockProvider;
import providers.SeatLockProviderImpl;
import services.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Step 1: Initialize the Services
        TheatreService theatreService = new TheatreService();
        MovieService movieService = new MovieService();
        ShowService showService = new ShowService();
        BookingService bookingService = new BookingService();
        SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService(bookingService, new SeatLockProviderImpl());


        // Step 2: Create some sample data
        // Create Movies
        Movie movie1 = movieService.createMovie("The Matrix");
        Movie movie2 = movieService.createMovie("Titanic");
        
        // Create Theatres
        Theatre theatre1 = theatreService.createTheatre("Cineplex", "Downtown");
        Theatre theatre2 = theatreService.createTheatre("Moviestar", "Uptown");

        // Create Screens in Theatres
        Screen screen1 = theatreService.createScreenInTheatre("Screen 1", "IMAX", theatre1);
        Screen screen2 = theatreService.createScreenInTheatre("Screen 2", "Regular", theatre2);

        // Create Seats in Screens
        theatreService.createSeatInScreen(1, 1, SeatType.BALCONY, 10.0, screen1);
        theatreService.createSeatInScreen(1, 2, SeatType.BENCH, 15.0, screen1);
        theatreService.createSeatInScreen(1, 3, SeatType.BALCONY, 10.0, screen2);

        // Step 3: Create Shows
        Show show1 = showService.createShow(movie1, screen1, new Date(), 7200); // 2 hours duration
        Show show2 = showService.createShow(movie2, screen2, new Date(), 10800); // 3 hours duration

        // Add Shows to Theatres (In the service methods)
        theatreService.addShowToTheatre(theatre1, show1);
        theatreService.addShowToTheatre(theatre2, show2);

        // Step 4: Display current shows in theatres
        System.out.println("Current Shows in Cineplex:");
        showService.getShowsForScreen(screen1).forEach(show -> {
            System.out.println("Show: " + show.getMovie().getTitle() + " at " + show.getStartTime());
        });

        System.out.println("Current Shows in Moviestar:");
        showService.getShowsForScreen(screen2).forEach(show -> {
            System.out.println("Show: " + show.getMovie().getTitle() + " at " + show.getStartTime());
        });

        User user1 = new User("john_doe", "John Doe", "john.doe@example.com");

        // User makes a booking for seats A1 and A2 in the show1
        List<Seat> seatsForShow1 = Arrays.asList(new Seat("A1"), new Seat("A2"));
        BookingService bookingServices = new BookingService();
        Booking booking = bookingServices.createBooking(show1, user1, seatsForShow1);

        // Print booking details
        System.out.println("Booking ID: " + booking.getId());
        System.out.println("User: " + booking.getUser().getName());
        System.out.println("Seats booked: ");
        for (Seat seat : booking.getSeatsBooked()) {
            System.out.println(seat.getSeatId());
}

        // Step 6: View booked seats for a show
        System.out.println("Booked Seats for Show 1:");
        bookingService.getBookedSeats(show1).forEach(seat -> System.out.println("Seat: " + seat.getId()));
    }
}
