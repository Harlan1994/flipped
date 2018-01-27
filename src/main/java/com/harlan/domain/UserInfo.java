package com.harlan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户的信息详情类封装
 */
@Table(name = "tb_userinfo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "locked", nullable = false)
    private boolean locked; // 用户是否被锁定，即账户不可用

    @Column(name = "realName")
    private String realName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "birthday")
    private Date birthday;

}
