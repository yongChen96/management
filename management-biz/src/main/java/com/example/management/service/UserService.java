package com.example.management.service;

import com.example.management.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author yongchen
 * @since 2020-09-01
 */
public interface UserService extends IService<User> {

    /**
     * @Author: yongchen
     * @Description: 获取登录用户信息
     * @Date: 16:01 2020/9/1
     * @Param: [userName]
     * @return: org.springframework.security.core.userdetails.UserDetails
     **/
    UserDetails loadUserByUsername(String userName);

}
