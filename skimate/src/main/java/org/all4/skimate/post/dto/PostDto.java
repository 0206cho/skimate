package org.all4.skimate.post.dto;


import lombok.Data;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.skiRounge.domain.Ski;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PostDto {

    private Long postId;

    private String postTitle;

    private String postContent;

    private int postClick;

    private LocalDate date;

    private Long skiNum;

    private String memberId;
}
