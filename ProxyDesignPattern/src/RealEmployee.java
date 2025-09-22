
public class RealEmployee implements EmployeeDB{

    @Override
    public void createEmployee(String client, Employee employee)  throws Exception{
        System.out.println("Employee created");
    }

    @Override
    public void deleteEmployee(String client, int employeeId) throws  Exception{

        System.out.println("Employee is deleted");
    }

    @Override
    public EmployeeDB getEmployee(String client, int employeeId) throws Exception{

        System.out.println("Fetched data");
        return null;
    }
}
