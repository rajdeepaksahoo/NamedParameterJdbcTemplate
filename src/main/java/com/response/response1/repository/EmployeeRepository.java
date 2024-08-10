package com.response.response1.repository;

import com.response.response1.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> allEmployees();
    public int addEmployee(Employee employee) throws Exception;

    Employee getByName(String name);

    Employee getById(Long id);

    List<String> getAllNames();
}
