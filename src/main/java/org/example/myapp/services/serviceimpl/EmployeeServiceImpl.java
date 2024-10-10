package org.example.myapp.services.serviceimpl;

import org.example.myapp.entity.Employee;
import org.example.myapp.services.EmployeeService;

import java.util.Arrays;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeList;

    public EmployeeServiceImpl(){
        employeeList= Arrays.asList(
                new Employee(1, "tushar1", 25, "nashik1", "tushar1@gmail.com", "tushar1@123"),
                new Employee(2, "tushar2", 25, "nashik2", "tushar2@gmail.com", "tushar2@123"),
                new Employee(3, "tushar3", 25, "nashik3", "tushar3@gmail.com", "tushar3@123"),
                new Employee(4, "tushar4", 25, "nashik4", "tushar4@gmail.com", "tushar4@123")
        );
    }

    @Override
    public Employee getEmployeeById(int empId) {
        for(Employee emp: employeeList){
            if(emp.getId()==empId){
                return emp;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
