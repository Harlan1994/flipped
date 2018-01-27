package com.harlan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Harlan1994 on 2017/11/21.
 */
@Table(name = "tb_tag")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(name = "tb_post_tag",
            joinColumns = @JoinColumn(name = "tagId"),
            inverseJoinColumns = @JoinColumn(name = "postId"))
    @Column(name = "posts")
    private Set<Post> posts;

    @Column(name = "name", nullable = false)
    private String name;
}
