package com.example.react.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "department")
    private String department;
    @Column(name = "role")
    private String role;

    public Employee(int id, String emailId, String firstName, String lastName, String department, String role){
        this.id = id;
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.role = role;
    }
    public Employee(){

    }

    public long getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
