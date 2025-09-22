public interface EmployeeDB {

    void createEmployee(String client,Employee employee) throws Exception;
    void deleteEmployee(String client, int employeeId) throws Exception;
    EmployeeDB getEmployee(String client, int employeeId) throws Exception;

}
