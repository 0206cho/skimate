package org.all4.skimate.reservation.service;

import java.sql.Date;
import java.time.LocalDate;

import org.all4.skimate.cash.dto.CashDTO;
import org.all4.skimate.cash.entity.Cash;
import org.all4.skimate.cash.repository.CashRepository;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.domain.Role;
import org.all4.skimate.member.repository.MemberRepository;
import org.all4.skimate.reservation.entity.Reservation;
import org.all4.skimate.reservation.repository.ReservationRepository;
import org.all4.skimate.skiRounge.repository.SkiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	private final SkiRepository skiRepository;
	private final CashRepository cashRepository;
	private final MemberRepository memberRepository;
	
	public Reservation saveReservation(CashDTO dto,Cash cash,String memberId) {
		LocalDate localDate = LocalDate.now();
	    Date date = java.sql.Date.valueOf(localDate);
		Reservation reservation = Reservation.builder()
				.reservation_pnum(dto.calPerson(dto))
				.reservation_stdate(date)
				.reservation_ski(dto.getSki())
				.reservation_board(dto.getBoard())
				.ski(skiRepository.findBySkiNum(dto.getSkiId()))
				.cash(cash)
				.member(memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("유저가 없습니다")))
				.build();
		return reservationRepository.save(reservation);
	}
	
	
}
