public class ProxyEmployee implements EmployeeDB{

    EmployeeDB employeeDB;

    public ProxyEmployee(){
        employeeDB = new RealEmployee();
    }

    @Override
    public void createEmployee(String client, Employee employee) throws Exception{
        if(client.equals("ADMIN")) {
            employeeDB.createEmployee(client, employee);
            return ;
        }

        throw new Exception("Access Denied");
    }

    @Override
    public void deleteEmployee(String client, int employeeId) throws Exception{
        if(client.equals("ADMIN")){
            employeeDB.deleteEmployee(client, employeeId);
            return ;
        }

        throw new Exception("Access Denied");
    }

    @Override
    public EmployeeDB getEmployee(String client, int employeeId) throws Exception{

        if(client.equals("ADMIN") || client.equals("USER"))
            return employeeDB.getEmployee(client, employeeId);

        throw new Exception("Access Denied");
    }

}
