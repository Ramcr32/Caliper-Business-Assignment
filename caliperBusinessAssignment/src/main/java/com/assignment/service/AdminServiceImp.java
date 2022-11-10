package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Admin;
import com.assignment.repository.AdminDao;
@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminDao adao;
	
	
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
		Admin existingAdmin = adao.findById(id)
				.orElseThrow(() -> new NotFoundException("admin is not found"));
		adao.delete(existingAdmin);
		return existingAdmin;
	}

}
