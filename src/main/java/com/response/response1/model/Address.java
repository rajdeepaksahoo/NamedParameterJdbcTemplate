package com.response.response1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

//@Table(name = "MY_MODEl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    private Long id;
    private String street;
    private String city;
}
