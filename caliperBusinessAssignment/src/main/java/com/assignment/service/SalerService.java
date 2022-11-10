package com.assignment.service;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Admin;
import com.assignment.model.Customer;
import com.assignment.model.Saler;

public interface SalerService {
	public Saler saveSaler(Saler saler) throws NotFoundException;

	public Saler update(Saler saler) throws NotFoundException;

	public Saler delete(Integer id) throws NotFoundException;
}
