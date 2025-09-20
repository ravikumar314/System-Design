import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements Observable{

    List<Observer> observerList = new ArrayList<>();
    private int stockCount = 0;


    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
      observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
       for(Observer obs : observerList)
           obs.update();
    }

    @Override
    public void setCount(int newStock) {
        if(stockCount == 0){
            notifyObserver();
        }

        stockCount += newStock;
    }

    @Override
    public int getCount() {
        return stockCount;
    }
}
