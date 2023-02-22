package org.all4.skimate.reservation.entity;


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
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservation_id; // 예약번호
	
	@Column(length = 500)
	private Date reservation_date; // 예약일
	
	@Column(length = 500)
	private Date reservation_stdate; // 둥록일
	
	@Column(length = 500)
	private String reservation_pnum; // 인원

//	@Column(length = 500)
//	private String ski_num; // 게시 일

	
}
