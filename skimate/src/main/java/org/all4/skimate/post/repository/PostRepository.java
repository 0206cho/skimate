package org.all4.skimate.post.repository;


import org.all4.skimate.post.domain.Post;
import org.all4.skimate.post.dto.PostDto;
import org.all4.skimate.skiRounge.domain.Ski;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findBySki(Ski ski);

    Post findByPostId(Long postId);
}
