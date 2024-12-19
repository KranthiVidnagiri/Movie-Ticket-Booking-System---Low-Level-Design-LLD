import model.*;
import providers.SeatLockProvider;
import providers.SeatLockProviderImpl;
import services.*;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        // Step 1: Initialize the Services
        TheatreService theatreService = new TheatreService();
        MovieService movieService = new MovieService();
        ShowService showService = new ShowService();
        BookingService bookingService = new BookingService();
        SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService(bookingService, new SeatLockProviderImpl());

        // Step 2: Create some sample data (Movies and Theatres)
        // Create Movies
        Movie movie1 = movieService.createMovie("The Matrix");
        Movie movie2 = movieService.createMovie("Titanic");
        Movie movie3 = movieService.createMovie("Avatar");
        Movie movie4 = movieService.createMovie("The Dark Knight");
        Movie movie5 = movieService.createMovie("Inception");
        Movie movie6 = movieService.createMovie("The Godfather");
        Movie movie7 = movieService.createMovie("Jurassic Park");
        Movie movie8 = movieService.createMovie("Interstellar");
        Movie movie9 = movieService.createMovie("The Lion King");
        Movie movie10 = movieService.createMovie("Pulp Fiction");
        Movie movie11 = movieService.createMovie("Forrest Gump");
        Movie movie12 = movieService.createMovie("The Shawshank Redemption");
        Movie movie13 = movieService.createMovie("The Avengers");
        Movie movie14 = movieService.createMovie("Star Wars: A New Hope");
        Movie movie15 = movieService.createMovie("Frozen");

        // Create Theatres
        Theatre theatre1 = theatreService.createTheatre("Cineplex", "Downtown");
        Theatre theatre2 = theatreService.createTheatre("Moviestar", "Uptown");
        Theatre theatre3 = theatreService.createTheatre("Grand Theatre", "Eastside");
        Theatre theatre4 = theatreService.createTheatre("Silver Screen", "Westside");
        Theatre theatre5 = theatreService.createTheatre("Star Theatre", "Central");

        // Create Screens in Theatres
        Screen screen1 = theatreService.createScreenInTheatre("Screen 1", "IMAX", theatre1);
        Screen screen2 = theatreService.createScreenInTheatre("Screen 2", "Regular", theatre2);
        Screen screen3 = theatreService.createScreenInTheatre("Screen 3", "3D", theatre3);
        Screen screen4 = theatreService.createScreenInTheatre("Screen 4", "Regular", theatre4);
        Screen screen5 = theatreService.createScreenInTheatre("Screen 5", "VIP", theatre5);
        Screen screen6 = theatreService.createScreenInTheatre("Screen 6", "IMAX", theatre1);
        Screen screen7 = theatreService.createScreenInTheatre("Screen 7", "3D", theatre2);
        Screen screen8 = theatreService.createScreenInTheatre("Screen 8", "Regular", theatre3);
        Screen screen9 = theatreService.createScreenInTheatre("Screen 9", "VIP", theatre4);
        Screen screen10 = theatreService.createScreenInTheatre("Screen 10", "IMAX", theatre5);

        // Create Seats in Screens
        theatreService.createSeatInScreen(1, 1, SeatType.BALCONY, 10.0, screen1);
        theatreService.createSeatInScreen(1, 2, SeatType.BENCH, 15.0, screen1);
        theatreService.createSeatInScreen(1, 3, SeatType.BALCONY, 10.0, screen2);
        theatreService.createSeatInScreen(1, 4, SeatType.BENCH, 12.0, screen2);
        theatreService.createSeatInScreen(1, 5, SeatType.SOFA, 25.0, screen3);
        theatreService.createSeatInScreen(1, 6, SeatType.BENCH, 12.0, screen3);
        theatreService.createSeatInScreen(1, 7, SeatType.BALCONY, 10.0, screen4);
        theatreService.createSeatInScreen(1, 8, SeatType.SOFA, 20.0, screen4);
        theatreService.createSeatInScreen(1, 9, SeatType.BENCH, 15.0, screen5);
        theatreService.createSeatInScreen(1, 10, SeatType.SOFA, 25.0, screen5);
        theatreService.createSeatInScreen(2, 1, SeatType.BENCH, 12.0, screen6);
        theatreService.createSeatInScreen(2, 2, SeatType.SOFA, 20.0, screen6);
        theatreService.createSeatInScreen(2, 3, SeatType.BALCONY, 15.0, screen7);
        theatreService.createSeatInScreen(2, 4, SeatType.BENCH, 15.0, screen7);
        theatreService.createSeatInScreen(2, 5, SeatType.SOFA, 25.0, screen8);
        theatreService.createSeatInScreen(2, 6, SeatType.BALCONY, 18.0, screen8);
        theatreService.createSeatInScreen(3, 1, SeatType.BENCH, 15.0, screen9);
        theatreService.createSeatInScreen(3, 2, SeatType.BALCONY, 20.0, screen9);
        theatreService.createSeatInScreen(3, 3, SeatType.SOFA, 30.0, screen10);

        // Step 3: Create Shows
        Show show1 = showService.createShow(movie1, screen1, new Date(), 7200); // 2 hours duration
        Show show2 = showService.createShow(movie2, screen2, new Date(), 10800); // 3 hours duration
        Show show3 = showService.createShow(movie3, screen3, new Date(), 7200); // 2 hours duration
        Show show4 = showService.createShow(movie4, screen4, new Date(), 7200); // 2 hours duration
        Show show5 = showService.createShow(movie5, screen5, new Date(), 10800); // 3 hours duration
        Show show6 = showService.createShow(movie6, screen6, new Date(), 7200); // 2 hours duration
        Show show7 = showService.createShow(movie7, screen7, new Date(), 10800); // 3 hours duration
        Show show8 = showService.createShow(movie8, screen8, new Date(), 7200); // 2 hours duration
        Show show9 = showService.createShow(movie9, screen9, new Date(), 7200); // 2 hours duration
        Show show10 = showService.createShow(movie10, screen10, new Date(), 10800); // 3 hours duration
        Show show11 = showService.createShow(movie11, screen1, new Date(), 7200); // 2 hours duration
        Show show12 = showService.createShow(movie12, screen2, new Date(), 10800); // 3 hours duration
        Show show13 = showService.createShow(movie13, screen3, new Date(), 7200); // 2 hours duration
        Show show14 = showService.createShow(movie14, screen4, new Date(), 10800); // 3 hours duration
        Show show15 = showService.createShow(movie15, screen5, new Date(), 7200); // 2 hours duration

        // Add Shows to Theatres
        theatreService.addShowToTheatre(theatre1, show1);
        theatreService.addShowToTheatre(theatre2, show2);
        theatreService.addShowToTheatre(theatre3, show3);
        theatreService.addShowToTheatre(theatre4, show4);
        theatreService.addShowToTheatre(theatre5, show5);
        theatreService.addShowToTheatre(theatre1, show6);
        theatreService.addShowToTheatre(theatre2, show7);
        theatreService.addShowToTheatre(theatre3, show8);
        theatreService.addShowToTheatre(theatre4, show9);
        theatreService.addShowToTheatre(theatre5, show10);
        theatreService.addShowToTheatre(theatre1, show11);
        theatreService.addShowToTheatre(theatre2, show12);
        theatreService.addShowToTheatre(theatre3, show13);
        theatreService.addShowToTheatre(theatre4, show14);
        theatreService.addShowToTheatre(theatre5, show15);

        // Step 4: Display current shows in theatres
        System.out.println("Current Shows in Cineplex:");
        showService.getShowsForScreen(screen1).forEach(show -> {
            System.out.println("Show: " + show.getMovie().getTitle() + " at " + show.getStartTime());
        });

        System.out.println("Current Shows in Moviestar:");
        showService.getShowsForScreen(screen2).forEach(show -> {
            System.out.println("Show: " + show.getMovie().getTitle() + " at " + show.getStartTime());
        });

        // Example booking
        User user1 = new User("john_doe", "John Doe", "john.doe@example.com");
        List<Seat> seatsForShow1 = Arrays.asList(new Seat("A1"), new Seat("A2"));
        Booking booking = bookingService.createBooking(show1, user1, seatsForShow1);

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
