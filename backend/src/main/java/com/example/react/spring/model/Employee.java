package com.example.react.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String emailId;
    @Column
    private String firstName;
    @Column
    private String lastName;

    public Employee(int id, String emailId, String firstName, String lastName){
        this.id = id;
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Employee(){

    }

    public int getId(){
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
}
