public class EmailNotification implements Observer{
    private String email;
    Observable observable;
    public EmailNotification(String email, Observable observable){
        this.observable = observable;
        this.email = email;
    }
    @Override
    public void update() {
        display(email);
    }

    void display(String email){
        System.out.println("Phone notification : stock updated" + email);
    }

}
