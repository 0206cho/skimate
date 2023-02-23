package org.all4.skimate.post.service;


import lombok.RequiredArgsConstructor;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.repository.MemberRepository;
import org.all4.skimate.post.domain.Post;
import org.all4.skimate.post.dto.PostDto;
import org.all4.skimate.post.dto.PostResponseDto;
import org.all4.skimate.post.repository.PostRepository;
import org.all4.skimate.skiRounge.domain.Ski;
import org.all4.skimate.skiRounge.repository.SkiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    private final SkiRepository skiRepository;

    private final MemberRepository memberRepository;

    public void postSave(PostDto postDto){

        Member member = memberRepository.findByMemberId(postDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 없습니다."));

        Ski ski = skiRepository.findById(postDto.getSkiNum())
                .orElseThrow(() -> new IllegalArgumentException("해당 스키가 없습니다."));

        Post post = Post.builder()
                .postTitle(postDto.getPostTitle())
                .postContent(postDto.getPostContent())
                .postClick(0)
                .date(LocalDate.now())
                .ski(ski)
                .member(member)
                .build();

        postRepository.save(post);

    }


    public List<PostResponseDto> postBySki(Long skiNum){
        Ski ski = skiRepository.findById(skiNum).orElseThrow(() -> new IllegalArgumentException("해당스키장 없어요"));
        List<Post> skiPost = postRepository.findBySkiOrderByPostIdDesc(ski);
        List<PostResponseDto> postList = new ArrayList<PostResponseDto>();


        for(Post post : skiPost){
            PostResponseDto dto = new PostResponseDto(post);
            postList.add(dto);
        }


        return postList;
    }


    public PostDto postById(Long postId){
        Post post = postRepository.findByPostId(postId);
        PostDto postD = PostDto.builder()
                .postTitle(post.getPostTitle())
                .postContent(post.getPostContent())
                .memberId(post.getMember().getMemberName())
                .date(post.getDate())
                .build();

        return postD;
    }

    public void postClick(Long postId){
        Post post = postRepository.findByPostId(postId);
        post.clickPost(post);
    }


}
