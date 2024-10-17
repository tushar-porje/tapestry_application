package org.example.myapp.services.serviceimpl;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.dao.EmployeeDao;
import org.example.myapp.entity.Employee;
import org.example.myapp.services.EmployeeService;
import org.example.myapp.services.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Inject
    private EmployeeService employeeService;

    @Override
    public boolean isValidLogin(String username, String password) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .anyMatch(employee -> employee.getUsername().equals(username)
                        && employee.getPassword().equals(password));
    }

    @Override
    public boolean isValidUserName(String userName) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .anyMatch(employee -> employee.getUsername().equals(userName));
    }

    @Override
    public boolean isValidPassword(String password) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .anyMatch(employee -> employee.getPassword().equals(password));
    }
}
