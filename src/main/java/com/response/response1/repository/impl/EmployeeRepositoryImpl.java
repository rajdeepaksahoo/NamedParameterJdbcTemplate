package com.response.response1.repository.impl;

import com.response.response1.model.Employee;
import com.response.response1.repository.EmployeeRepository;
import com.response.response1.repository.rowmapper.EmployeeRowMapper;
import com.response.response1.repository.rowmapper.NameRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Employee> allEmployees() {
        List<Employee> employeeList = namedParameterJdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeRowMapper());
        return employeeList;
    }

    @Override
    public int addEmployee(Employee employee) throws Exception {
        String sql = "INSERT INTO employee (id, name, address_id) VALUES (:id, :name, :address_id)";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", employee.getId());
        parameters.put("name", employee.getName());
        parameters.put("address_id", employee.getAddressId());
        return namedParameterJdbcTemplate.update(sql, parameters);
    }
    @Override
    public Employee getByName(String name)  {
        String sql = "SELECT * FROM employee WHERE name = :name";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);

        return namedParameterJdbcTemplate.queryForObject(sql, parameters, new EmployeeRowMapper());
    }

    @Override
    public Employee getById(Long id) {
        String sql = "SELECT * FROM address WHERE id = :id";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);

        return namedParameterJdbcTemplate.queryForObject(sql, parameters, new EmployeeRowMapper());
    }
    @Override
    public List<String> getAllNames() {
        String sql = "SELECT name FROM employee";
        return namedParameterJdbcTemplate.query(sql,new NameRowMapper());
    }
}
