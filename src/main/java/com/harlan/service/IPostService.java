package com.harlan.service;

import com.harlan.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by Harlan1994 on 2017/11/21.
 */
public interface IPostService {
    Post getPost(Long id);

    Page<Post> getPosts(Integer page, Integer size);

    Page<Post> getPagedPostsByTag(Integer page, Integer size, String tag);

    Page<Post> getPostsByKeywords(Integer page, Integer size,String[] keywords);

    void updatePost(Post post);

    void deletePostById(Long id);
}
