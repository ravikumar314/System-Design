import java.util.ArrayList;
import java.util.List;

public class Show {

    int showId;
    Movie movieDetails;
    Screen screenInfo;
    int startTime;
    List<Integer> bookedSeat = new ArrayList<>();

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public void setMovieDetails(Movie movieDetails) {
        this.movieDetails = movieDetails;
    }

    public void setScreenInfo(Screen screenInfo) {
        this.screenInfo = screenInfo;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setBookedSeat(List<Integer> bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public List<Integer> getBookedSeat() {
        return bookedSeat;
    }

    public int getShowId() {
        return showId;
    }

    public Screen getScreenInfo() {
        return screenInfo;
    }
}
