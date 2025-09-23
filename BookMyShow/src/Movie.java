public class Movie {
    String movieName;
    int movieId;
    int movieDuration;

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }
}
