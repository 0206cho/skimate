package org.all4.skimate.lesson.service;

import org.all4.skimate.lesson.entity.Lesson;
import org.all4.skimate.lesson.repository.LessonRepository;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	public void saveLesson(Lesson lesson, String memberId, String memberName) {
			Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("없습니다"));
			lesson.setMember_id(member.getMemberId());
			lesson.setMember_Name(member.getMemberName());
			lessonRepository.save(lesson);
			System.out.println("등록완료");
	}
	
	public Lesson getLession(int lessionId) {
		
		return lessonRepository.findByLessonId(lessionId);
	}
	
}
