package com.example.react.spring.controller;

import com.example.react.spring.model.Employee;
import com.example.react.spring.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController{
   EmployeeRepository employeeRepository;

   public EmployeeController(EmployeeRepository employeeRepository){
       this.employeeRepository = employeeRepository;
   }
    //get all employees
   @GetMapping
   public List<Employee> getEmployees(){
       return employeeRepository.findAll();
   }

   //get employee by id
   @GetMapping("/{id}")
   public Employee getEmployee(@PathVariable Long id){
       return employeeRepository.findById(Math.toIntExact(id)).orElseThrow(RuntimeException::new);
   }

   @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee employee)
       throws URISyntaxException {
       Employee saveEmployee = employeeRepository.save(employee);
       /*return ResponseEntity.created(new URI("/clients/" +
               saveEmployee.getId())).body(saveEmployee);*/
       return ResponseEntity.created(new URI("/clients/" +
               saveEmployee.getId())).body(saveEmployee);
        }

    @PutMapping("/{id}")
    public ResponseEntity updateEmployee(@PathVariable Long id,
                                         RequestBody Employee){
       Employee currentEmployee = employeeRepository.findById(Math.toIntExact(id)).orElseThrow(RuntimeException::new);
       currentEmployee.setFirstName(currentEmployee.getFirstName());
       currentEmployee.setLastName(currentEmployee.getLastName());
       currentEmployee.setDepartment(currentEmployee.getDepartment());
       currentEmployee.setRole(currentEmployee.getRole());

       return ResponseEntity.ok(currentEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id){
       employeeRepository.deleteById(Math.toIntExact(id));
       return ResponseEntity.ok().build();
    }

}