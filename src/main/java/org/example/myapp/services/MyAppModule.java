package org.example.myapp.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.example.myapp.services.serviceimpl.EmployeeServiceImpl;
import org.example.myapp.services.serviceimpl.LoginServiceImpl;

public class MyAppModule {
    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
    {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10 m");
        configuration.add(SymbolConstants.ENABLE_PAGELOADING_MASK, "false");
    }

    public static void bind(ServiceBinder binder) {
        binder.bind(LoginService.class, LoginServiceImpl.class).withId("LoginServiceImpl");
        binder.bind(EmployeeService.class, EmployeeServiceImpl.class).withId("EmployeeServiceImpl");
    }

}
