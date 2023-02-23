package org.all4.skimate.lesson.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.all4.skimate.lesson.dto.LessonDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name ="lesson")
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lessonId; // 강습 id
	
	@Column(length = 500)
	private String lesson_lsdate; // 강습 일자
	
	@Column(length = 100)
	private String lesson_category; // 강습 종류
	
	@Column(length = 100)
	private int lesson_price; // 강습 비용
	
	@Column(length = 100)
	private String lesson_title; // 제 목 
	
	@Column(length = 500)
	private String lesson_content; // 내 용
	
	private String lesson_date; // 게시일
    
    private String member_id; // 글쓴이 아이디    
    private String member_Name; // 글쓴이 이름
    
    @Column(length = 100)
    private int ski_id; // 스키장 번호
    private String ski_name; // 스키장 이름

	public static Lesson writeLesson(LessonDTO dto) {
		Lesson lesson = new Lesson();
		lesson.setLesson_title(dto.getTitle());
		lesson.setLesson_content(dto.getContent());
		lesson.setLesson_price(dto.getPrice());
		lesson.setLesson_category(dto.getCategory());
		lesson.setLesson_lsdate(dto.getStartDate() + " ~ " +dto.getEndDate());
		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now = LocalDate.now();
		lesson.setLesson_date(now.toString());
		lesson.setSki_id(dto.getSkiId());
		lesson.setSki_name(dto.getSkiName());
		
        // 결과 출력
        System.out.println(now);
		return lesson;
	}

}
