package com.assignment.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Admin;
import com.assignment.model.Customer;
import com.assignment.service.AdminService;
import com.assignment.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/")
	public ResponseEntity<Customer> newCustomerHandler(@Valid @RequestBody Customer customer){
		Customer newcustomer = customerService.saveAdmin(customer);
		return new ResponseEntity<>(newcustomer, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteMappingHandler(@PathVariable("id") Integer id) {
		Customer customer = customerService.delete(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<Customer> updateAdminHandler(@RequestBody Customer customer) {
		Customer updatedCustomer = customerService.update(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
	}
}
