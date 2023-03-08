package org.all4.skimate.lesson.repository;

import java.util.ArrayList;
import java.util.List;

import org.all4.skimate.lesson.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

	Lesson findByLessonId(int LessonId);
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM lesson WHERE end_yn = 'N'"
    )
    List<Lesson>endLesson();
}
