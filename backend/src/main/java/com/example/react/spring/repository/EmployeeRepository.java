package com.example.react.spring.repository;

import com.example.react.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByRole(boolean published);
    List<Employee> findByDepartment(String department);
}
