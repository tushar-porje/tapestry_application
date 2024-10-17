package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.components.Header;
import org.example.myapp.services.EmployeeService;
import org.example.myapp.services.LoginService;

public class Login {

    @Property
    @Validate("required")
    private String username;

    @Property
    @Validate("required")
    private  String password;

    @InjectComponent
    private Form loginForm;

    @InjectComponent("username")
    private TextField userNameField;

    @InjectComponent("password")
    private PasswordField passwordField;
    
    @Inject
    LoginService loginService;

    @Inject
    EmployeeService employeeService;

    @Component
    private Header header;

    private int empId;

    void onValidateFromLoginForm(){

        if (!loginService.isValidUserName(username)) {
            loginForm.recordError(userNameField,"Invalid username");
        }
        if(!loginService.isValidPassword(password)){
            loginForm.recordError(passwordField,"invalid password");
        }
        if (!loginService.isValidLogin(username,password)){
            loginForm.recordError("Invalid username and password");
        }
    }

    public Object onSuccessFromLoginForm() {
        return EmployeeList.class;
    }
//    public Object onSuccessFromLoginForm() {
//        this.empId = employeeService.getIdByUserName(this.username);
//        return EmployeeDetails.class;
//    }
//    int onPassivate(){
//        return this.empId;
//    }

}
