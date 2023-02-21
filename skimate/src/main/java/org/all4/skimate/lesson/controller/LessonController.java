package org.all4.skimate.lesson.controller;

import java.util.ArrayList;
import java.util.List;

import org.all4.skimate.lesson.entity.Lesson;
import org.all4.skimate.lesson.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LessonController {
	
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
	
	@GetMapping("/api/lesson/list")
	public List<Lesson> getItems() {
		List<Lesson> lesson = lessonRepository.findAll();
		return lesson;
	}
	
}
