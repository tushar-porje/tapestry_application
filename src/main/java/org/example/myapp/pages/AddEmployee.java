package org.example.myapp.pages;


import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.components.Header;
import org.example.myapp.entity.Employee;
import org.example.myapp.pages.EmployeeList;
import org.example.myapp.services.EmployeeService;

public class AddEmployee {

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
    private Form addEmployeeForm;

    @Component
    private Header header;

    void onValidateFromAddEmployeeForm() {
        // Check if username is already taken
        if (employeeService.isUsernameTaken(employeeUsername)) {
            addEmployeeForm.recordError("Username is already taken.");
        }
    }

    Object onSuccessFromAddEmployeeForm() {
        Employee newEmployee = new Employee();
        newEmployee.setName(employeeName);
        newEmployee.setAge(employeeAge);
        newEmployee.setAddress(employeeAddress);
        newEmployee.setUsername(employeeUsername);
        newEmployee.setPassword(employeePassword);

        System.out.println("pk of saved employee: "+employeeService.addEmployee(newEmployee));
        return EmployeeList.class;
    }
}
