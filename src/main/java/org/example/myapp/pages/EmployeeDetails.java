package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.components.Header;
import org.example.myapp.entity.Employee;

public class EmployeeDetails {
    @Property
    private Employee employee;

    @Component
    private Header header;

    void onActivate(int empId){
        employee=new Employee(1, "tushar1", 25, "nashik1", "tushar1@gmail.com", "tushar1@123");
    }
}
