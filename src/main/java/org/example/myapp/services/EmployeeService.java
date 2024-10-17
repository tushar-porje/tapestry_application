package org.example.myapp.services;


import org.example.myapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(int empId);
    List<Employee> getAllEmployees();
    Integer addEmployee(Employee employee);
    boolean isUsernameTaken(String userName);
    boolean deleteEmployee(int empId);
    void updateEmployee(Employee employee);
    int getIdByUserName(String username);
}
