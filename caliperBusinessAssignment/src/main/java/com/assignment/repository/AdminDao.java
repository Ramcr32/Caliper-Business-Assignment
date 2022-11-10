package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Admin;
import com.assignment.model.Customer;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {

}
