
public class Main {
    public static void main(String[] args) {

        try{
            EmployeeDB db = new ProxyEmployee();

            db.createEmployee("ADMI", new Employee());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}