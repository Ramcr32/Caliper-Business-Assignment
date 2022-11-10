package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Customer;
import com.assignment.model.Saler;
import com.assignment.repository.SalerDao;

@Service
public class SalerServiceImp implements SalerService {
	@Autowired 
	private SalerDao sdao;

	@Override
	public Saler saveAdmin(Saler saler) throws NotFoundException {
		
		return sdao.save(saler);
	}

	@Override
	public Saler update(Saler saler) throws NotFoundException {
		Saler existsaler = sdao.findById(saler.getUserId())
				.orElseThrow(() -> new NotFoundException("saler not found"));
		return existsaler;
	}

	@Override
	public Saler delete(Integer id) throws NotFoundException {
		Saler existsaler = sdao.findById(id)
				.orElseThrow(() -> new NotFoundException("saler not found"));
		sdao.delete(existsaler);
		return existsaler;
	}
	
	
}
