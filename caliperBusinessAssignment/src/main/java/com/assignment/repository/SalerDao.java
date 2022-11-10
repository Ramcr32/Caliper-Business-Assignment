package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Admin;
import com.assignment.model.Customer;
import com.assignment.model.Saler;
@Repository
public interface SalerDao extends JpaRepository<Saler, Integer> {

}
