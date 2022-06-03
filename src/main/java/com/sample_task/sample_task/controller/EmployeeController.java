package com.sample_task.sample_task.controller;


import com.sample_task.sample_task.model.Employee;
import com.sample_task.sample_task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    //To fetch all the employees records.
    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }


    //To create an employee record
    @PostMapping("/add")
    public String saveEmployee(@RequestBody Employee employee){
       return employeeService.saveEmployee(employee);
    }


    //To update an employee record
    @PutMapping("/employee/{id}")
    public String updateEmp(@RequestBody Employee employee, @PathVariable String id){
        return employeeService.updateEmp(employee,id);
    }

    //To delete an employee record
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }

}
