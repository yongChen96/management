package com.example.management.controller;


import com.example.commons.mybatisplus.config.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 操作日志记录 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/operateLog")
@Api(value = "OperateLogController", tags = "操作日志记录")
public class OperateLogController extends BaseController {

}
