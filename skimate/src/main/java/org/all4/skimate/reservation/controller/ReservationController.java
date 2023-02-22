package org.all4.skimate.reservation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
	
	@PostMapping("/pay")
	public String pay() {
		return "ddddd";
	}
	
	
}
