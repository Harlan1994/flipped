package com.harlan.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Harlan1994 on 2017/11/21.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostByTitle(String title);
    List<Post> findPostsByTitle(String title);
    List<Post> findPostsByTags(String[] tags);
}
