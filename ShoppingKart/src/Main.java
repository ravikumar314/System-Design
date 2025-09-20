//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ShoopingKart cart = new ShoopingKart();
        cart.setPaymentStrategy(new PayPalPayment("ravi314cs@gmail.com"));
        cart.checkout(100.0);
    }
}