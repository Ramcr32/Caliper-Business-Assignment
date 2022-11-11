package com.assignment.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@PrimaryKeyJoinColumn(name = "salerId")
public class Saler extends User {
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "saler")
	private List<SalerItems> items;
}
