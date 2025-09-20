//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Observable iphoneStock = new IphoneObservable();

        Observer obj1 = new PhoneNotification("6392027647", iphoneStock);
        Observer obj2 = new EmailNotification("ravikumar314cs@gmail.com", iphoneStock);
        Observer obj3 = new EmailNotification("dsnjiabdhjldb", iphoneStock);

        iphoneStock.addObserver(obj1);
        iphoneStock.addObserver(obj2);
        iphoneStock.addObserver(obj3);
        iphoneStock.setCount(100);
        iphoneStock.removeObserver(obj3);
        iphoneStock.setCount(-100);
        System.out.println(iphoneStock.getCount());
        iphoneStock.setCount(10);
    }
}