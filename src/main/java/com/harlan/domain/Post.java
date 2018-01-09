package com.harlan.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * UserInfo: Harlan1994
 * Date: 2017/9/16
 * Time: 17:44
 * Description: 周记实体类
 */
@Table(name = "tb_post")
@Data
@Entity
@NoArgsConstructor
public class Post extends BaseModel{

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "lastModifyTime", nullable = false)
    private Date lastModifyTime;

    @Column(name = "publishTime", nullable = false)
    private Date publishTime;

    // 1.正常 2.删除 3.只对自己可见（个人发布）
    @Column(name = "locked", nullable = false)
    private int locked;

    // 阅读数
    @Column(name = "readCount", nullable = false)
    private int readCount;

    /**
     * post相关的tag
     */
    @JoinTable(name = "tb_post_tag", joinColumns = @JoinColumn(name = "postId"), inverseJoinColumns = @JoinColumn(name = "tagId"))
    @ManyToMany
    private Set<Tag> tags;
}