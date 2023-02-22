package org.all4.skimate.lesson.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.all4.skimate.jwt.service.JwtService;
import org.all4.skimate.lesson.dto.LessonDTO;
import org.all4.skimate.lesson.entity.Lesson;
import org.all4.skimate.lesson.repository.LessonRepository;
import org.all4.skimate.lesson.service.LessonService;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.repository.MemberRepository;
import org.all4.skimate.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	LessonService lessonService;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	JwtService jwtService;

	// DB의 data vue로 전송
	@GetMapping("/api/lesson/list")
	public List<Lesson> getList() {
		List<Lesson> lesson = lessonRepository.findAll();
		return lesson;
	}

	// 글 작성하기 위해서 vue의 form 입력 값 spring으로 받기
	@PostMapping("/api/lesson/write")
	public void write(@RequestBody LessonDTO dto, HttpServletRequest request, BindingResult bindingResult) {
		String accessTocken = jwtService.extractAccessToken(request)
				.orElseThrow(() -> new IllegalArgumentException("없습니다"));
		String memberId = jwtService.extractMemberId(accessTocken)
				.orElseThrow(() -> new IllegalArgumentException("없습니다"));
		
		// name을 가져오기 위해서 id를 통해 member전체를 찾은 후 그 member에서 id를 뽑아옴
		Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("없습니다"));
		String memberName = member.getMemberName();
		
		if (bindingResult.hasErrors()) {
			System.out.println("바인딩에러");
		}

		try {
			Lesson lesson = Lesson.writeLesson(dto);
			lessonService.saveLesson(lesson, memberId, memberName);
		} catch (Exception e) {
			System.out.println("등록 에러");
		}
	}

	// 상세페이지 id 넘기기
	@GetMapping("/api/lesson/detail/{lessonId}")
	public void detail(@PathVariable("lessonId") int lessonId) {
		System.out.println(">>>>>>>>> id : "+ lessonId);		
	}
	
//	// 삭제
//	@DeleteMapping("/api/lesson/delete/{lessonId}")
//    public void removeLesson(@PathVariable("lessonId") int lessonId) {
//        Lesson lesson = lessonRepository.findByLessonId(lessonId);
//
//        lessonRepository.delete(lesson);
//    }
}
