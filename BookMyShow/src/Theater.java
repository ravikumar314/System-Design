import java.util.ArrayList;
import java.util.List;

public class Theater {
    int theaterId;
    String address;
    List<Screen> screenList = new ArrayList<>();
    List<Show> showList = new ArrayList<>();

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public List<Show> getShowList() {
        return showList;
    }

}
