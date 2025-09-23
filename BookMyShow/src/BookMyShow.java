import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheaterController theaterController;

    BookMyShow(){
        movieController = new MovieController();
        theaterController = new TheaterController();
    }

    void initialize(){

        // create moview
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }


    public void createMovies(){

        // movie 1
        Movie avenger = new Movie();
        avenger.setMovieId(1);
        avenger.setMovieName("Iron Man");
        avenger.setMovieDuration(192);

        // movie 2
        Movie dc = new Movie();
        dc.setMovieId(2);
        dc.setMovieName("BatMan");
        dc.setMovieDuration(160);

        // add to movie controller
        movieController.allMovies.add(avenger);
        movieController.allMovies.add(dc);

        // add cit -> movie

        List<Movie> mvList1 = movieController.cityListMap.getOrDefault("Bangalore", new ArrayList<>());
        mvList1.add(avenger);
        mvList1.add(dc);

        movieController.cityListMap.put("Bangalore", mvList1);

        List<Movie> mvList2 = movieController.cityListMap.getOrDefault("Delhi", new ArrayList<>());
        mvList2.add(avenger);
        mvList2.add(dc);

        movieController.cityListMap.put("Delhi", mvList2);

    }

    public void createTheatre(){



        Movie avengerMovie = movieController.getMovieByName("Iron Man");
        Movie baahubali = movieController.getMovieByName("BatMan");

        Theater inoxTheatre = new Theater();
        inoxTheatre.setTheaterId(1);
        inoxTheatre.setScreenList(createScreen());
        inoxTheatre.setAddress("Bangalore");
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShow(1, inoxTheatre.getScreenList().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShow(2, inoxTheatre.getScreenList().get(0), baahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShowList(inoxShows);


        Theater pvrTheatre = new Theater();
        pvrTheatre.setTheaterId(2);
        pvrTheatre.setScreenList(createScreen());
        pvrTheatre.setAddress("Delhi");
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShow(3, pvrTheatre.getScreenList().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShow(4, pvrTheatre.getScreenList().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShowList(pvrShows);

        theaterController.addTheater(inoxTheatre, "Bangalore");
        theaterController.addTheater(pvrTheatre, "Delhi");

    }

    public List<Screen> createScreen(){

        List<Screen> screenList = new ArrayList<>();

        Screen screen1 = new Screen();
        screen1.setId(1);
        screen1.setSeatList(creatSeats());

        // add to list
        screenList.add(screen1);
        return screenList;
    }

    public  List<Seat> creatSeats(){

        List<Seat> seatList = new ArrayList<>();

        // silver level seat
        for(int i = 1 ; i < 51; i++){
            Seat seat = new Seat();
            seat.setRow(i);
            seat.setId(i);
            seat.setPrice(100);
            seat.setSeatType(SeatCategory.SILVER);
        }

        // Gold level seat

        for(int i = 51 ; i < 101; i++){
            Seat seat = new Seat();
            seat.setRow(i);
            seat.setId(i);
            seat.setPrice(200);
            seat.setSeatType(SeatCategory.GOLD);
        }

        // Platinum level seat
        for(int i = 101 ; i < 151; i++){
            Seat seat = new Seat();
            seat.setRow(i);
            seat.setId(i);
            seat.setPrice(300);
            seat.setSeatType(SeatCategory.PLATINUM);
        }

        return seatList;
    }

    public Show createShow(int showId, Screen screen, Movie movie, int showStartTime ){

        Show show = new Show();
        show.setShowId(showId);
        show.setScreenInfo(screen);
        show.setMovieDetails(movie);
        show.setStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;

    }

     void createBooking(String userCity, String movieName){

        //1. search the location
        List<Movie> movieList = movieController.getMoviesByCity(userCity);

        if(movieList == null){
            if(movieList == null){
                System.out.println("No show currentlly");
                return ;
            }
        }

        // 2. select movie interested
        Movie bookingMovie = null;

        for(Movie movie : movieList){
            if(movie.getMovieName().equals(movieName)){
                bookingMovie = movie;
                break;
            }
        }

        if(bookingMovie == null){
            System.out.println("Movie not available");
            return ;
        }

        // 3. get all show for this movie
        Map<Theater, List<Show>> showTheaterWise = theaterController.getAllShow(bookingMovie, userCity);

        // 4. select the show user interested
        Map.Entry<Theater,List<Show>> entry = showTheaterWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        // 5 select the seat
        int seatNumber = 32;
        List<Integer> bookedSeats = interestedShow.getBookedSeat();

        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);

            //startPayment
            Booking booking = new Booking();

            List<Seat> myBookedSeats = new ArrayList<>();

            for(Seat screenSeat : interestedShow.getScreenInfo().getSeatList()) {
                if(screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setSeatList(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("Ticket Booked");



    }




}
