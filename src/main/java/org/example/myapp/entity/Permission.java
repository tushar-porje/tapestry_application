package org.example.myapp.entity;

import javax.persistence.*;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "permissionId")
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
