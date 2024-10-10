package org.example.myapp.services;


import org.example.myapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(int empId);
    List<Employee> getAllEmployees();
}
