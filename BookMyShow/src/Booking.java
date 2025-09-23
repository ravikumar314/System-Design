import java.util.List;

public class Booking {
    Show show;
    List<Seat> seatList;
    Payemnt payemnt;

    public void setShow(Show show) {
        this.show = show;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public void setPayemnt(Payemnt payemnt) {
        this.payemnt = payemnt;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public Payemnt getPayemnt() {
        return payemnt;
    }

    public Show getShow() {
        return show;
    }

}
