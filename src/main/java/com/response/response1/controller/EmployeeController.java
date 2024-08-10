package com.response.response1.controller;

import com.response.response1.model.Employee;
import com.response.response1.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.allEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Employee> getEmployeesByName(@PathVariable String name){
        return new ResponseEntity<>(employeeService.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getEmployeesByName(){
        return new ResponseEntity<>(employeeService.getAllNames(), HttpStatus.OK);
    }
}
