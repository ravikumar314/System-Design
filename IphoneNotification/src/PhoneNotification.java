public class PhoneNotification implements Observer{
    private String phone;
    Observable observable;
    public PhoneNotification(String phone, Observable observable){
        this.observable = observable;
        this.phone = phone;
    }
    @Override
    public void update() {
        display(phone);
    }

    void display(String phone){
        System.out.println("Phone notification : stock updated" + phone);
    }
}
