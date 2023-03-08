package org.all4.skimate.reservation.controller;

import java.util.List;

import org.all4.skimate.lesson.entity.Lesson;
import org.all4.skimate.lesson.repository.LessonRepository;
import org.all4.skimate.reservation.entity.Reservation;
import org.all4.skimate.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

	@Autowired
	ReservationRepository reservationRepository;
	
	@PostMapping("/pay")
	public String pay() {
		return "ddddd";
	}

	// DB의 data vue로 전송
	@GetMapping("/list")
	public List<Reservation> getList() {
		List<Reservation> reser = reservationRepository.findAll();
		return reser;
	}
}
