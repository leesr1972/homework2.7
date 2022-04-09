package pro.sky.java.course2.homework2_7.service;

import pro.sky.java.course2.homework2_7.data.Employee;

public interface EmployeeService {
    public Employee addEmployee (String firstName, String lastName);
    public Employee dismissEmployee (String firstName, String lastName);
    public Employee findEmloyee (String firstName, String lastName);
    public String getAllStaff();
}
