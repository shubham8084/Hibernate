package com.nt.entity;



import java.sql.Date;

import lombok.Data;
@Data
public class BankAccount {
	private Integer AccNo;
	private String HoloderName;
	private Float Balance;
	private Date LastUpdate;

}
