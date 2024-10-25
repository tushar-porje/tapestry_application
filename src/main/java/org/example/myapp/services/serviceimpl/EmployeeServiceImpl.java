package org.example.myapp.services.serviceimpl;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.dao.EmployeeDao;
import org.example.myapp.entity.Employee;
import org.example.myapp.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeList;

    @Inject
    private EmployeeDao employeeDao;

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeDao.findEmployeeById(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        employeeList = employeeDao.findAllEmployee();
        return employeeList;
    }

    @Override
    public Integer addEmployee(Employee employee) {

        return employeeDao.saveEmployee(employee);
    }

    @Override
    public boolean isUsernameTaken(String userName) {
        return employeeDao.isUsernameTaken(userName);
//        return employeeList.stream().anyMatch(employee -> employee.getUsername().equals(userName));
    }

    @Override
    public boolean deleteEmployee(int empId) {
        return employeeDao.deleteEmployeeById(empId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public int getIdByUserName(String username) {
        Employee employee = employeeDao.findEmployeeByUserName(username);
        return employee.getId();
    }
}
