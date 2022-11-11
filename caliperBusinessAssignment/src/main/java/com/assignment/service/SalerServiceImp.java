package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exceptions.NotFoundException;
import com.assignment.model.Customer;
import com.assignment.model.Items;
import com.assignment.model.Saler;
import com.assignment.model.SalerItems;
import com.assignment.repository.ItemDao;
import com.assignment.repository.SalerDao;
import com.assignment.repository.SalerItemDao;

@Service
public class SalerServiceImp implements SalerService {
	@Autowired
	private SalerDao sdao;

	@Autowired
	private SalerItemDao saleridao;

	@Autowired
	private ItemDao idao;

	@Override
	public Saler saveSaler(Saler saler) throws NotFoundException {

		return sdao.save(saler);
	}

	@Override
	public Saler update(Saler saler) throws NotFoundException {
		Saler existsaler = sdao.findById(saler.getUserId()).orElseThrow(() -> new NotFoundException("saler not found"));
		return existsaler;
	}

	@Override
	public Saler delete(Integer id) throws NotFoundException {
		Saler existsaler = sdao.findById(id).orElseThrow(() -> new NotFoundException("saler not found"));
		sdao.delete(existsaler);
		return existsaler;
	}

	@Override
	public SalerItems addNewItem(SalerItems item) {
		Items existingitem = idao.findById(item.getItemId())
				.orElseThrow(() -> new NotFoundException("item is not present with id " + item.getItemId()));

		return saleridao.save(item);
	}

	@Override
	public SalerItems updateItem(SalerItems item) throws NotFoundException {
		SalerItems updateitem = saleridao.findById(item.getItemId())
				.orElseThrow(() -> new NotFoundException("item is not present"));

		return saleridao.save(item);
	}

	

}
