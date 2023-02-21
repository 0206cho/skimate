package org.all4.skimate.lesson.entity;

import lombok.Getter;

import java.util.Date;

import javax.persistence.*;


@Getter
@Entity
@Table(name ="lesson")
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lesson_id; // 강습 id
	
	@Column(length = 500)
	private String lesson_lsdate; // 강습 일자
	
	@Column(length = 100)
	private String lesson_category; // 강습 종류
	
	@Column(length = 100)
	private String lesson_price; // 강습 비용
	
	@Column(length = 100)
	private String lesson_title; // 제 목 
	
	@Column(length = 500)
	private String lesson_content; // 내 용
	
	@Column(length = 500)
	private Date lesson_date; // 게시 일

}
