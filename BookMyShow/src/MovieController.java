import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    Map<String, List<Movie>> cityListMap;
    List<Movie> allMovies;

    public  MovieController(){
        cityListMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }


    public  void addMovie(Movie movie, String city){

        allMovies.add(movie);

        List<Movie> mv1 = cityListMap.getOrDefault(city, new ArrayList<>());
        mv1.add(movie);
        cityListMap.put(city, mv1);
    }

    // all other function here

    Movie getMovieByName(String movieName) {

        for(Movie movie : allMovies) {
            if((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public Map<String, List<Movie>> getCityListMap() {
        return cityListMap;
    }

    List<Movie> getMoviesByCity(String city) {
        return cityListMap.get(city);
    }

}
