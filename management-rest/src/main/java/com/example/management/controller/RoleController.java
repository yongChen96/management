package com.example.management.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.commons.mybatisplus.config.BaseController;
import io.swagger.annotations.Api;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/role")
@Api(value = "RoleController", tags = "角色表")
public class RoleController extends BaseController {

}
