package com.harlan.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;
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
public class Post implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1782474744437162148L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "summary")
    private String summary;

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
    @JoinTable(name = "tb_post_tag", joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "tagId"))
    @ManyToMany
    private Set<Tag> tags;

    @Column(name = "url", nullable = false)
    private String url;

    /**
     * 文章对应的作者
     */
    @OneToOne(fetch = FetchType.EAGER)
    private User user;
}