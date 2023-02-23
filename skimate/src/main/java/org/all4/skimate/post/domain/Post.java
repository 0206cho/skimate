package org.all4.skimate.post.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.post.dto.PostDto;
import org.all4.skimate.skiRounge.domain.Ski;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String postTitle;

    private String postContent;

    private int postClick;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ski_num")
    private Ski ski;


    private LocalDate date;


    public void clickPost(PostDto postDto){
        int postClick = postDto.getPostClick();
        this.postClick = ++postClick;
    }

    public void updatePost(PostDto postDto){
        postTitle = postDto.getPostTitle();
        postContent = postDto.getPostContent();
        date = postDto.getDate();
    }



    @Builder
    public Post(String postTitle, String postContent, int postClick, Member member, Ski ski, LocalDate date) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postClick = postClick;
        this.member = member;
        this.ski = ski;
        this.date = date;
    }
}
