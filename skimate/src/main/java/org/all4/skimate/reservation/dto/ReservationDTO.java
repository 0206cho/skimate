package org.all4.skimate.reservation.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ReservationDTO {
	private int reservation_id; // 예약번호
	
	private Date reservation_date; // 예약일
	
	private Date reservation_stdate; // 둥록일
	
	private String reservation_pnum; // 인원
}
