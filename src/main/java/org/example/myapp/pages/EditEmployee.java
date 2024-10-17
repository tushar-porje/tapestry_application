package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.myapp.components.Header;
import org.example.myapp.services.EmployeeService;
import org.example.myapp.entity.Employee;

public class EditEmployee {

    @Property
    private String employeeName;

    @Property
    private int employeeAge;

    @Property
    private String employeeAddress;

    @Property
    private String employeeUsername;

    @Property
    private String employeePassword;

    @Inject
    private EmployeeService employeeService;

    @Component
    private Header header;

    private int empId;

    void onActivate(int empId) {
        this.empId = empId;
        Employee employee = employeeService.getEmployeeById(empId);

        if (employee != null) {
            employeeName = employee.getName();
            employeeAge = employee.getAge();
            employeeAddress = employee.getAddress();
            employeeUsername = employee.getUsername();
            employeePassword = employee.getPassword();
        }
    }

    Object onSuccessFromEditForm() {
        Employee employee = new Employee();
        employee.setId(empId);
        employee.setName(employeeName);
        employee.setAge(employeeAge);
        employee.setAddress(employeeAddress);
        employee.setUsername(employeeUsername);
        employee.setPassword(employeePassword);

        employeeService.updateEmployee(employee);

        return EmployeeList.class;
    }

    int onPassivate(){
        return empId;
    }
}
