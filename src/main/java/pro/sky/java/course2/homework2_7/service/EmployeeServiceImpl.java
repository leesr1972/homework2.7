package pro.sky.java.course2.homework2_7.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework2_7.data.Employee;
import pro.sky.java.course2.homework2_7.exceptions.BadRequest;
import pro.sky.java.course2.homework2_7.exceptions.NotFound;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> staffOfEmployee = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (staffOfEmployee.containsKey(lastName + firstName)) {
            throw new BadRequest();
        } else {
            staffOfEmployee.put(lastName + firstName, newEmployee);
            return newEmployee;
        }
    }

    @Override
    public Employee dismissEmployee(String firstName, String lastName) {
        Employee dismissedEmployee = new Employee(firstName, lastName);
        if (staffOfEmployee.containsKey(lastName + firstName)) {
            staffOfEmployee.remove(lastName + firstName, dismissedEmployee);
            return dismissedEmployee;
        } else {
            throw new NotFound();
        }
    }

    @Override
    public Employee findEmloyee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (staffOfEmployee.containsKey(lastName + firstName)) {
            return employee;
        } else {
            throw new BadRequest();
        }
    }

    @Override
    public String getAllStaff() {
        if (staffOfEmployee.size() == 0) {
            throw new NotFound();
        }
        Set<String> allStaff = staffOfEmployee.keySet();
        return "Список сотрудников:" + allStaff;
    }
}
