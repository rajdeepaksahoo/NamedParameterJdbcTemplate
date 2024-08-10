package com.response.response1;

import com.response.response1.model.Address;
import com.response.response1.model.Employee;
import com.response.response1.repository.AddressRepository;
import com.response.response1.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class Response1Application implements CommandLineRunner {
	private EmployeeRepository employeeRepository;
	private AddressRepository addressRepository;
	public static void main(String[] args) {
		SpringApplication.run(Response1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			List<Address> addressList = List.of(new Address(1l, "Shivbhag", "Ameerpet"),
					new Address(2l, "Nellore", "Nellore"),
					new Address(3l, "Chhatia", "Jajpur"),
					new Address(4l, "Cuttack", "Cuttack"),
					new Address(5l, "Patia", "Bhubaneswar"));

			for (Address address:addressList){
				try {
					addressRepository.addAddress(address);
				}catch (Exception e){
					log.error(e.getMessage());
				}
			}

			List<Employee> employees = List.of(new Employee(1l, "Raz", 3l),
					new Employee(2l, "Pratyush", 4l),
					new Employee(3l, "Eneesha", 2l),
					new Employee(4l, "Srinu", 5l),
					new Employee(5l, "Razdeepak", 5l));
			for (Employee employee:employees){
				try {
					employeeRepository.addEmployee(employee);
				}catch (Exception e){
					log.error(e.getMessage());
				}
			}
		}catch (Exception exception){
			log.error(exception.getMessage());
		}
		System.out.println(employeeRepository.allEmployees());
	}
}