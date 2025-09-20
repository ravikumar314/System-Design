public interface Observable {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
    void setCount(int newStock);
    int getCount();
}
