package org.example.myapp.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int id;
    private String name;
    private int age;
    private String address;
    private String username;
    private String password;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "employeeId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name = "employee_permission", joinColumns = @JoinColumn(name = "employeeId"), inverseJoinColumns = @JoinColumn(name = "permissionId"))
    private Set<Permission> permissions;

    public Employee() {
    }

    public Employee(String name, int age, String address, String username, String password){
        this.name = name;
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public Employee(int id, String name, int age, String address, String username, String password) {
        this(name, age, address, username, password);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        boolean exists = this.roles.stream()
                .anyMatch(r -> r.getName().equals(role.getName()));

        if (!exists) {
            this.roles.add(role);
        }
    }

    public void removeRole(Role role){
        this.roles.removeIf(a -> a.getName().equals(role.getName()));
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(Permission permission){
        boolean exists = this.permissions.stream()
                .anyMatch(p -> p.getName().equals(permission.getName()));

        if (!exists) {
            this.permissions.add(permission);
        }
    }

    public void removePermission(Permission permission){
        this.roles.removeIf(a -> a.getName().equals(permission.getName()));
    }

}
