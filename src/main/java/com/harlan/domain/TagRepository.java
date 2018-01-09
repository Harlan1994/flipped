package com.harlan.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Harlan1994 on 2017/11/21.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findFirstByName(String name);
}
