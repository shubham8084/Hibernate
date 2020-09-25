package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {

@Id
private int PID;
private String PName;
private float Price;
private float Qty;
	
}
