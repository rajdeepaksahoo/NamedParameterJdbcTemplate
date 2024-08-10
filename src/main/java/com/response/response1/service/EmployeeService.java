package com.response.response1.service;

import com.response.response1.model.Employee;
import com.response.response1.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public List<Employee> allEmployees(){
        return employeeRepository.allEmployees();
    }
    public Employee getByName(String name){
        return employeeRepository.getByName(name);
    }
    public List<String> getAllNames(){
        return employeeRepository.getAllNames();
    }
}
