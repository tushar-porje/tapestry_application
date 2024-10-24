package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.myapp.components.Header;
import org.example.myapp.entity.Employee;
import org.example.myapp.services.EmployeeService;

public class EmployeeDetails {
    @Property
    private Employee employee;

    @Inject
    EmployeeService employeeService;

    @Component
    private Header header;

    private int empId;

    @Inject
    private PageRenderLinkSource pageRenderLinkSource;

    void onActivate(int empId){
        this.empId=empId;
        employee= employeeService.getEmployeeById(empId);
    }

    Object onSubmitFromEdit() {
        return this.pageRenderLinkSource.createPageRenderLinkWithContext(EditEmployee.class, this.empId);
    }

    int onPassivate() {
        return empId;
    }

    Object onSubmitFromDelete() {
        employeeService.deleteEmployee(employee.getId());
        return EmployeeList.class;
    }
}
