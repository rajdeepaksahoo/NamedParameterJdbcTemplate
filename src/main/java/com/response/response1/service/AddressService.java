package com.response.response1.service;

import com.response.response1.model.Address;
import com.response.response1.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    public Address getAddressById(Long id){
        return addressRepository.getById(id);
    }
}
