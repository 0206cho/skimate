package org.all4.skimate.reservation.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.all4.skimate.cash.entity.Cash;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.skiRounge.domain.Ski;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservation_id; // 예약번호
	
	@Column
	private Date reservation_date; // 예약일
	
	@Column
	private Date reservation_stdate; // 둥록일
	
	@Column
	private String reservation_pnum; // 인원
	
	@Column
	private int reservation_board; // 보드 개수
	
	@Column
	private int reservation_ski; // 스키 개수
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "cashNum")
	private Cash cash;
	
	@ManyToOne
	@JoinColumn(name = "skiNum")
	private Ski ski;
	
	
}
