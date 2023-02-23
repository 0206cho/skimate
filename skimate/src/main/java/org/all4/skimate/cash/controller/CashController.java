package org.all4.skimate.cash.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.all4.skimate.cash.dto.CashDTO;
import org.all4.skimate.cash.entity.Cash;
import org.all4.skimate.cash.repository.CashRepository;
import org.all4.skimate.cash.service.CashService;
import org.all4.skimate.jwt.service.JwtService;
import org.all4.skimate.lesson.service.LessonService;
import org.all4.skimate.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cash")
public class CashController {
	
	private final CashService cashService;
	private final ReservationService reservationService;
	private final LessonService lessonService;
	
	private final JwtService jwtService;
	
	@PostMapping("/reservation")
	public void pay(@RequestBody CashDTO dto, HttpServletRequest request) {
		String accessTocken = jwtService.extractAccessToken(request).orElseThrow(()->new IllegalArgumentException("없습니다"));
		String memberId = jwtService.extractMemberId(accessTocken).orElseThrow(()->new IllegalArgumentException("없습니다"));
		
		Cash cash = cashService.saveCash(dto);
		reservationService.saveReservation(dto, cash, memberId);
	}
	
	@PostMapping("/lesson")
	public void payLesson(@RequestBody CashDTO dto, HttpServletRequest request) {
		String accessTocken = jwtService.extractAccessToken(request).orElseThrow(()->new IllegalArgumentException("없습니다"));
		String memberId = jwtService.extractMemberId(accessTocken).orElseThrow(()->new IllegalArgumentException("없습니다"));
		
		Cash cash = cashService.saveCashLesson(dto);
		lessonService.MentoSetCash(dto.getLessonId(), cash);
		
	}
	


}
