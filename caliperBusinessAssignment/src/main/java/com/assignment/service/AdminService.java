package com.assignment.service;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Admin;

public interface AdminService {
	public Admin saveAdmin(Admin admin) throws NotFoundException;

	public Admin update(Admin admin) throws NotFoundException;

	public Admin delete(Integer id) throws NotFoundException;
}
