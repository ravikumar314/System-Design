import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {

    Map<String, List<Theater>> cityListMap;
    List<Theater> theaterList;

    public TheaterController(){
        cityListMap = new HashMap<>();
        theaterList = new ArrayList<>();
    }

    public List<Theater> getTheaterList() {
        return theaterList;
    }

    public void addTheater(Theater theater, String city){

        theaterList.add(theater);

        List<Theater> th1 = cityListMap.getOrDefault(city, new ArrayList<>());
        th1.add(theater);
        cityListMap.put(city, th1);

    }


    Map<Theater, List<Show>> getAllShow(Movie movie, String city) {

        //get all the theater of this city

        Map<Theater, List<Show>> theatreVsShows = new HashMap<>();

        List<Theater> theatres = cityListMap.get(city);

        //filter the theatres which run this movie

        for(Theater theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShowList();

            for(Show show : shows) {
                if(show.movieDetails.getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }



}
