package com.harlan.service;

import com.harlan.domain.Tag;
import com.harlan.domain.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
