package com.example.commons.annotation.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: 当前登录用户信息
 * @Author: yongchen
 * @Date: 2020/9/1 11:56
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -8607405616743847600L;

    /**
     * 用户id
     **/
    private String id;

    /**
     * 用户姓名
     **/
    private String userName;

    /**
     * 用户呢称
     **/
    private String nickName;

    /**
     * 用户手机号
     **/
    private String phone;

    /**
     * 用户邮箱
     **/
    private String mail;

    /**
     * 用户角色名称
     **/
    private String roleName;

    /**
     * 用户角色编码
     **/
    private String roleCode;

    public User() {

    }

    public User(String id, String userName, String nickName, String phone, String mail, String roleName, String roleCode) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.phone = phone;
        this.mail = mail;
        this.roleName = roleName;
        this.roleCode = roleCode;
    }
}
