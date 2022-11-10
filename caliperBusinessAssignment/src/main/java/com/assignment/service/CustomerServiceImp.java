package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Customer;
import com.assignment.model.Items;
import com.assignment.repository.CustomerDao;
import com.assignment.repository.ItemDao;

@Repository
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDao cdao;
	
	@Autowired 
	private ItemDao idao;
	@Override
	public Customer saveAdmin(Customer customer) throws NotFoundException {

		return cdao.save(customer);
	}

	@Override
	public Customer update(Customer customer) throws NotFoundException {
		Customer existcustomer = cdao.findById(customer.getUserId())
				.orElseThrow(() -> new NotFoundException("customer not found"));
		return existcustomer;
	}

	@Override
	public Customer delete(Integer id) throws NotFoundException {
		Customer existcustomer = cdao.findById(id).orElseThrow(() -> new NotFoundException("customer not found"));
		cdao.delete(existcustomer);
		return existcustomer;
	}

	@Override
	public List<Items> allItems() {
		return idao.findAll();
	}

	@Override
	public Items getItem(Integer id, Integer itemqty) throws NotFoundException {
		Items item = idao.findById(id).orElseThrow(()-> new NotFoundException("item not found"));
		if(item.getItemQty()>=itemqty) {
			item.setItemQty(item.getItemQty()-itemqty);
			idao.save(item);
		}
		return item;
	}

	@Override
	public String farmInfrastructureService(Integer customerId) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
