package com.assignment.service;

import java.util.List;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Admin;
import com.assignment.model.Customer;
import com.assignment.model.Items;

public interface CustomerService {
	public Customer saveAdmin(Customer customer) throws NotFoundException;

	public Customer update(Customer customer) throws NotFoundException;

	public Customer delete(Integer id) throws NotFoundException;

	public List<Items> allItems();

	public Items getItem(Integer id, Integer itemqty) throws NotFoundException;

	public String farmInfrastructureService(Integer customerId) throws NotFoundException;
}
