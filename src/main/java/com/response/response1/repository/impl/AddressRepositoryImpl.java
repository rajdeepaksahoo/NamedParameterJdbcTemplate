package com.response.response1.repository.impl;

import com.response.response1.model.Address;
import com.response.response1.repository.AddressRepository;
import com.response.response1.repository.rowmapper.AddressRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Address> allAddresses() {
        List<Address> addressList = namedParameterJdbcTemplate.query("SELECT * FROM EMPLOYEE", new AddressRowMapper());
        return addressList;
    }

    public int addAddress(Address address) throws Exception{
        try {
            String sql = "INSERT INTO address (id, street, city) VALUES (:id, :street, :city)";

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", address.getId());
            parameters.put("street", address.getStreet());
            parameters.put("city", address.getCity());

            return namedParameterJdbcTemplate.update(sql, parameters);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return 0; // or handle it according to your needs
        }
    }
    @Override
    public Address getById(Long id) {
        String sql = "SELECT * FROM address WHERE id = :id";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);

        return namedParameterJdbcTemplate.queryForObject(sql, parameters, new AddressRowMapper());
    }

    /*
     private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Employee> allEmployees() {
        List<Employee> employeeList = namedParameterJdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeRowMapper());
        return employeeList;
    }

    @Override
    public int addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (id, name, address_id) VALUES (:id, :name, :address_id)";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", employee.getId());
        parameters.put("name", employee.getName());
        parameters.put("address_id", employee.getAddressId());
        return namedParameterJdbcTemplate.update(sql, parameters);
    }
     */
}
