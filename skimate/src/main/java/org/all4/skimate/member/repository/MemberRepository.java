package org.all4.skimate.member.repository;

import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.domain.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberId(String memberId);

    Optional<Member> findByRefreshToken(String refreshToken);

    Optional<Member> findBySocialTypeAndSocialId(SocialType socialType, String SocialId);
}
