package org.all4.skimate.post.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.skiRounge.domain.Ski;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class PostDto {

    private Long postId;

    private String postTitle;

    private String postContent;

    private int postClick;

    private LocalDate date;

    private Long skiNum;

    private String memberId;


    @Builder
    public PostDto(Long postId, String postTitle, String postContent, int postClick, LocalDate date, Long skiNum, String memberId) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postClick = postClick;
        this.date = date;
        this.skiNum = skiNum;
        this.memberId = memberId;
    }
}
