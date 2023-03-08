package org.all4.skimate.member.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberDto {

    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberPhone;
    private String memberAddress;
}
