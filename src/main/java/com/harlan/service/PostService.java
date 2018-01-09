package com.harlan.service;

import com.harlan.domain.Post;
import com.harlan.domain.PostRepository;
import com.harlan.domain.Tag;
import com.harlan.domain.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Harlan1994 on 2017/11/21.
 */
@Service
public class PostService implements IPostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;

    @Override
    public Post getPost(Long id) {
        return postRepository.findOne(id);
    }

    /**
     * 按照时间倒序分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Post> getPosts(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "publishTime");
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> getPagedPostsByTag(Integer page, Integer size, String tagName) {
        Tag tag = tagRepository.findFirstByName(tagName);
        return null;
    }

    @Override
    public Page<Post> getPostsByKeywords(Integer page, Integer size, String[] keywords) {
        return null;
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePostById(Long id) {

    }
}
