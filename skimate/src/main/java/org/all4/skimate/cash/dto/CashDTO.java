package org.all4.skimate.cash.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CashDTO {
	private int price;
	
	private int bigPerson;
	
	private int smallPerson;
	
	private int ski;
	
	private int board;
	
	private int skiId;
}
