package com.response.response1.controller;

import com.response.response1.model.Address;
import com.response.response1.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return new ResponseEntity<>(addressService.getAddressById(id), HttpStatus.OK);
    }
}
