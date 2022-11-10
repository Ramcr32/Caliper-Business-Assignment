package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Items;

@Repository
public interface ItemDao extends JpaRepository<Items, Integer>{

}
