package org.all4.skimate.lesson.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class LessonDTO {
	
	private String title;
	private String content;
	private String category;
	private String startDate;
	private String endDate;
	private int price;
	
}