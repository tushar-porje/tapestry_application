package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.components.Header;
import org.example.myapp.entity.Employee;
import org.example.myapp.services.EmployeeService;

import java.util.Arrays;
import java.util.List;

public class EmployeeList {

    private List<Employee> employees;

    @Property
    private Employee currentEmployee;

    @Inject
    EmployeeService employeeService;

    @Component
    private Header header;

    void setupRender(){
        employees = employeeService.getAllEmployees();
    }

    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

}
