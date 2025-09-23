import java.util.ArrayList;
import java.util.List;

public class Screen {
    int id;
    List<Seat> seatList = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public int getId() {
        return id;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

}
