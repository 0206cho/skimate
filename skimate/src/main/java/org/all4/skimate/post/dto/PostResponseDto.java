package org.all4.skimate.post.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.all4.skimate.post.domain.Post;

import java.time.LocalDate;

@Data

public class PostResponseDto {

    private Long postId;

    private String postTitle;

    private String postContent;

    private int postClick;

    private LocalDate date;

    private String memberId;


    public PostResponseDto(Post entity){
        this.postId = entity.getPostId();
        this.postTitle = entity.getPostTitle();
        this.postContent = entity.getPostContent();
        this.postClick = entity.getPostClick();
        this.date = entity.getDate();
        this.memberId = entity.getMember().getMemberName();
    }
}
