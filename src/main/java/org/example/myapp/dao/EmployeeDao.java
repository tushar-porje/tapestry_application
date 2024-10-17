package org.example.myapp.dao;

import org.example.myapp.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee findEmployeeById(int id);
    public List<Employee> findAllEmployee();
    public Integer saveEmployee(Employee employee);
    public boolean isUsernameTaken(String username);
    public boolean deleteEmployeeById(int empId);
    public void updateEmployee(Employee employee);
    public Employee findEmployeeByUserName(String username);
}
