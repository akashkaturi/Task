package com.sample_task.sample_task.service;


import com.sample_task.sample_task.model.Employee;
import com.sample_task.sample_task.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    //Fetching all the records
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();

    }

    //Creating a new Employee Record
    public String saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return "Employee Already exists";
        }
        else{
            employeeRepository.save(employee);
            return "Employee Saved";
        }
    }

    //Updating Employee
    public String updateEmp(Employee employee, String id) {
        List<Employee> e = employeeRepository.findAll();
        int i = -1;
        for (Employee t : e) {
            if (t.getId().equals(id)) {
                i++;
            }
        }
        if (i == -1) {
            return "Data Doesn't exist";
        }
        employeeRepository.save(employee);
        return "Data with ID: " +id+" is updated";
    }

    //Delete employee Record
    public String deleteEmployee(String id) {
        List<Employee> e = employeeRepository.findAll();
        String ans = "";
        for (Employee t : e) {
            if (t.getId().equals(id)) {
                ans = t.getId();
            }
        }
        employeeRepository.deleteById(ans);
        if (ans.length()>0) {
            return "Data Deleted";
        }
        return "Data Doesn't Exists";
    }




}
