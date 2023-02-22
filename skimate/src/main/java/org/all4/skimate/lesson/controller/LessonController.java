package org.all4.skimate.lesson.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.all4.skimate.jwt.service.JwtService;
import org.all4.skimate.lesson.dto.LessonDTO;
import org.all4.skimate.lesson.entity.Lesson;
import org.all4.skimate.lesson.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LessonController {

	// 연동 확인
//	@GetMapping("/api/lesson")
//    public List<String> getItems() {
//        List<String> items = new ArrayList<>();
//        items.add("test1");
//        items.add("테스트2");
//        items.add("테스트3");
//        return items;
//    }

	@Autowired
	LessonRepository lessonRepository;

	@Autowired
	JwtService jwtService;

	// DB의 data vue로 전송
	@GetMapping("/api/lesson/list")
	public List<Lesson> getItems() {
		List<Lesson> lesson = lessonRepository.findAll();
		return lesson;
	}

	@PostMapping("/api/lesson/write")
	public void pay(@RequestBody LessonDTO dto, HttpServletRequest request) {
		String accessTocken = jwtService.extractAccessToken(request)
				.orElseThrow(() -> new IllegalArgumentException("없습니다"));
		String memberId = jwtService.extractMemberId(accessTocken)
				.orElseThrow(() -> new IllegalArgumentException("없습니다"));

		System.out.println("제목 : " + dto.getTitle());
		System.out.println("내용 : " + dto.getContent());
		System.out.println("가격 : " + dto.getPrice());
		System.out.println("카테고리 : " + dto.getCategory());
		System.out.println("start : " + dto.getStartDate());
		System.out.println("end : " + dto.getEndDate());
	}

}
