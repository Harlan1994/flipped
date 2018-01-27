package com.harlan.service;

import com.harlan.domain.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITagService {

    List<Tag> getAllTags();
}
