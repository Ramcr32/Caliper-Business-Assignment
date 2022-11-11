package com.assignment.service;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Admin;
import com.assignment.model.Items;

public interface AdminService {
	public Admin saveAdmin(Admin admin) throws NotFoundException;

	public Admin update(Admin admin) throws NotFoundException;

	public Admin delete(Integer id) throws NotFoundException;
	
	public Items addNewItem(Items item);
	
	public Items updateItem(Items item) throws NotFoundException;
	
	public Items deleteItem(Integer id) throws NotFoundException;
}
