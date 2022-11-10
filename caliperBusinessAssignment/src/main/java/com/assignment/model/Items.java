package com.assignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Items {
	@Id
	private Integer itemId;
	private Integer price;
	private String itemName;
	private Integer itemQty;
}
