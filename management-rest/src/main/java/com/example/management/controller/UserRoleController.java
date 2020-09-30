package com.example.management.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.commons.mybatisplus.config.BaseController;
import io.swagger.annotations.Api;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/userRole")
@Api(value = "UserRoleController", tags = "用户角色表")
public class UserRoleController extends BaseController {

}
