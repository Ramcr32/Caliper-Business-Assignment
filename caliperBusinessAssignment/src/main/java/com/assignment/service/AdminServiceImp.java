package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Admin;
import com.assignment.model.Items;
import com.assignment.repository.AdminDao;
import com.assignment.repository.ItemDao;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminDao adao;

	@Autowired
	private ItemDao idao;

	@Override
	public Admin saveAdmin(Admin admin) throws NotFoundException {

		return adao.save(admin);
	}

	@Override
	public Admin update(Admin admin) throws NotFoundException {
		Admin existingAdmin = adao.findById(admin.getUserId())
				.orElseThrow(() -> new NotFoundException("admin is not found"));
		return existingAdmin;
	}

	@Override
	public Admin delete(Integer id) throws NotFoundException {
		Admin existingAdmin = adao.findById(id).orElseThrow(() -> new NotFoundException("admin is not found"));
		adao.delete(existingAdmin);
		return existingAdmin;
	}

	@Override
	public Items addNewItem(Items item) {

		return idao.save(item);
	}

	@Override
	public Items updateItem(Items item) throws NotFoundException {
		Items updateItem = idao.findById(item.getItemId())
				.orElseThrow(() -> new NotFoundException("item is not found "));
		idao.save(item);
		return item;
	}

	@Override
	public Items deleteItem(Integer id) throws NotFoundException {
		Items item = idao.findById(id).orElseThrow(() -> new NotFoundException("item is not found "));
		idao.delete(item);
		return item;
	}

}
