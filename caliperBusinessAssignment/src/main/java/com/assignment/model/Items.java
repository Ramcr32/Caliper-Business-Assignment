package com.assignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Items {
	@Id
	private Integer itemId;
	@NotNull
	private Integer price;
	@NotNull
	private String itemName;
	@NotNull
	private Integer itemQty;
}
