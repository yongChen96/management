package com.example.management.service.impl;

import com.example.management.entity.Role;
import com.example.management.mapper.RoleMapper;
import com.example.management.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author yongchen
 * @since 2020-09-01
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
