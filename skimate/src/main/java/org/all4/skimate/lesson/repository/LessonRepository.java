package org.all4.skimate.lesson.repository;

import org.all4.skimate.lesson.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

	Lesson findByLessonId(int LessonId);
	
}
