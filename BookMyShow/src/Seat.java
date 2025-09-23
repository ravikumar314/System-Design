public class Seat {

    int id;
    int row;
    int price;
    SeatCategory seatType;

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeatType(SeatCategory seatType) {
        this.seatType = seatType;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public SeatCategory getSeatType() {
        return seatType;
    }

    public int getRow() {
        return row;
    }

}
