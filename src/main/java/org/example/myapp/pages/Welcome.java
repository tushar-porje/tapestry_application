package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.example.myapp.components.Header;

public class Welcome {

    @Property
    private String username;

    @Component
    private Header header;

    public void onActivate(String username) {
        this.username = username;
    }

    public String onPassivate() {
        return username;
    }
}


