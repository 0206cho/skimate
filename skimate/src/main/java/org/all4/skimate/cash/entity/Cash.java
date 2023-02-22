package org.all4.skimate.cash.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="cash")
public class Cash {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cash_num; // 캐시번호
	
	@Column(length = 500)
	private int cash_price; // 가격

	@Column(length = 500)
	private String cash_category; // 캐시분류

	
}
