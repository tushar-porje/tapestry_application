package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.example.myapp.components.Header;

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

    @InjectPage
    private Welcome welcomePage;

    @Component
    private Header header;

    void onValidateFromLoginForm(){
        if (!username.equals("tushar123@gmail.com")) {
            loginForm.recordError(userNameField,"Invalid username");
        }
        if(!password.equals("tushar@123")){
            loginForm.recordError(passwordField,"invalid password");
        }
    }

    public Object onSuccessFromLoginForm() {
        welcomePage.onActivate(username);
        return welcomePage;
    }
}
