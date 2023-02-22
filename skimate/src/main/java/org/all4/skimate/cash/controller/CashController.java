package org.all4.skimate.cash.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.all4.skimate.cash.dto.CashDTO;
import org.all4.skimate.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cash")
public class CashController {
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("/reservation")
	public void pay(@RequestBody CashDTO dto, HttpServletRequest request) {
		String accessTocken = jwtService.extractAccessToken(request).orElseThrow(()->new IllegalArgumentException("없습니다"));
		String memberId = jwtService.extractMemberId(accessTocken).orElseThrow(()->new IllegalArgumentException("없습니다"));
		
		
		
		
		System.out.println("받은 가격 : " + dto.getPrice());
		System.out.println("대인 : " + dto.getBigPerson());
		System.out.println("소인 : " + dto.getSmallPerson());
		System.out.println("스키 : " + dto.getSki());
		System.out.println("보드 : " + dto.getBoard());
		System.out.println("스키 ID : " + dto.getSkiId());
		System.out.println("로그인 ID  : " + memberId);
	}
	
//	@PostMapping("/lesson")
//	public String lesson() {
//		return "ddddd";
//	}

}
