package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Admin;
import com.assignment.model.Customer;
import com.assignment.model.Saler;
import com.assignment.model.SalerItems;
@Repository
public interface SalerItemDao extends JpaRepository<SalerItems, Integer> {

}
