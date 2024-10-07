package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.components.Header;
import org.example.myapp.entity.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeList {

    private List<Employee> employees;

    @Property
    private Employee currentEmployee;

    @Component
    private Header header;

    void setupRender(){
        employees = Arrays.asList(
                new Employee(1, "tushar1", 25, "nashik1", "tushar1@gmail.com", "tushar1@123"),
                new Employee(2, "tushar2", 25, "nashik2", "tushar2@gmail.com", "tushar2@123"),
                new Employee(3, "tushar3", 25, "nashik3", "tushar3@gmail.com", "tushar3@123"),
                new Employee(4, "tushar4", 25, "nashik4", "tushar4@gmail.com", "tushar4@123")
        );
    }

    public List<Employee> getEmployees() {
        if(employees == null){
            employees =Arrays.asList(
                    new Employee(1, "tushar1", 25, "nashik1", "tushar1@gmail.com", "tushar1@123"),
                    new Employee(2, "tushar2", 25, "nashik2", "tushar2@gmail.com", "tushar2@123"),
                    new Employee(3, "tushar3", 25, "nashik3", "tushar3@gmail.com", "tushar3@123"),
                    new Employee(4, "tushar4", 25, "nashik4", "tushar4@gmail.com", "tushar4@123")
            );
        }
        return employees;
    }

}
