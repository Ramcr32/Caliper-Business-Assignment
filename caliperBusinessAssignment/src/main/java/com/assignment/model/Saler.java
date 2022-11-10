package com.assignment.model;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@PrimaryKeyJoinColumn(name = "salerId")
public class Saler extends User {

}
