package org.all4.skimate.post.controller;


import lombok.RequiredArgsConstructor;
import org.all4.skimate.jwt.service.JwtService;
import org.all4.skimate.member.service.MemberService;
import org.all4.skimate.post.dto.PostDto;
import org.all4.skimate.post.dto.PostResponseDto;
import org.all4.skimate.post.service.PostService;
import org.all4.skimate.skiRounge.service.SkiService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final JwtService jwtService;

    @GetMapping("/skiPost/{skiNum}")
    public List<PostResponseDto> postList(@PathVariable Long skiNum){
        List<PostResponseDto> postList = postService.postBySki(skiNum);

        return postList;
    }

    @PostMapping("/skiPostWirte")
    public ResponseEntity<String> postWrite(@RequestBody PostDto postDto, HttpServletRequest request){
        String tokenMemberId = jwtService.getTokenMemberId(request);
        postDto.setMemberId(tokenMemberId);
        postService.postSave(postDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
