package com.assignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class SalerItems {
	@ManyToOne
	private Saler saler;
	@Id
	private Integer itemId;

	@NotNull
	private String itemName;
	@NotNull
	private Integer itemQty;
}
