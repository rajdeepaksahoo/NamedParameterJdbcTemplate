package com.response.response1.repository.rowmapper;

import com.response.response1.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setName(rs.getString("name"));
        employee.setAddressId(rs.getLong("address_id"));  // Foreign key reference
        return employee;
    }
}

