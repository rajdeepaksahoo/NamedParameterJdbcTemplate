package com.response.response1.repository.rowmapper;

import com.response.response1.model.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();
        address.setId(rs.getLong("id"));
        address.setStreet(rs.getString("street"));
        address.setCity(rs.getString("city"));
        return address;
    }
}
