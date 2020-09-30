package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.commons.enums.AccStatusEnum;
import com.example.commons.exception.BizException;
import com.example.management.entity.Role;
import com.example.management.entity.User;
import com.example.management.entity.UserRole;
import com.example.management.mapper.UserMapper;
import com.example.management.service.RoleService;
import com.example.management.service.UserRoleService;
import com.example.management.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author yongchen
 * @since 2020-09-01
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;
    
    /**
     * @Author: yongchen
     * @Description: 获取登录用户信息
     * @Date: 16:51 2020/9/1
     * @Param: [userName]
     * @return: org.springframework.security.core.userdetails.UserDetails
     **/
    @Override
    public UserDetails loadUserByUsername(String userName) {

        UserInfoVO vo = new UserInfoVO();

        // 1.获取登录用户基本信息
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getUserName, userName);
        User user = this.getOne(userQueryWrapper);
        if (null == user){
            log.info("登录用户不存在");
            throw new UsernameNotFoundException("登录用户不存在，请重新输入！");
        }
        if (StringUtils.equals(AccStatusEnum.ACC_FREEZE.getCode(), user.getAccStatus())){
            log.info("账号被冻结");
            throw new BizException("账号也被冻结，请联系管理员解冻后在登录！");
        }
        if (StringUtils.equals(AccStatusEnum.ACC_LOGOUT.getCode(), user.getAccStatus())){
            log.info("该账号也注销");
            throw new BizException("该账号也注销");
        }
        vo.setUser(user);
        // 2.获取登录用户角色信息
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.lambda().eq(UserRole::getUserId, user.getId());
        List<UserRole> list = userRoleService.list(userRoleQueryWrapper);
        if (CollectionUtils.isEmpty(list)){
            List<String> collect = list.stream()
                    .filter(userRole -> userRole.getRoleId() != null)
                    .map(userRole -> userRole.getRoleId())
                    .collect(Collectors.toList());
            List<Role> roles = roleService.listByIds(collect);
            vo.setRoles(roles);
        }
        return vo;
    }
}
