package org.all4.skimate.lesson.repository;

import org.all4.skimate.lesson.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, String> {

//	Lesson findByLessonId(int lessonId);
	
}
