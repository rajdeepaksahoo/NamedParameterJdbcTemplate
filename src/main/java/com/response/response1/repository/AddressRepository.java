package com.response.response1.repository;

import com.response.response1.model.Address;

import java.util.List;

public interface AddressRepository {
    public List<Address> allAddresses();
    public int addAddress(Address employee) throws Exception;

    Address getById(Long id);
}
