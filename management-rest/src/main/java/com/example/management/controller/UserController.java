package com.example.management.controller;


import com.example.commons.api.Result;
import com.example.commons.mybatisplus.config.IdGen;
import com.example.commons.service.RedisService;
import com.example.commons.utils.CaptchaUtil;
import com.example.management.service.UserService;
import com.example.management.utils.JwtTokenUtil;
import com.example.management.vo.UserInfoVO;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;
import com.example.commons.mybatisplus.config.BaseController;
import io.swagger.annotations.Api;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.UUID;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = "用户信息表")
public class UserController extends BaseController {

    @Resource
    private IdGenerator idGenerator;
    @Resource
    private CaptchaUtil captchaUtil;
    @Resource
    private RedisService redisService;
    @Resource
    private UserService userService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    /**
     * @Author: yongchen
     * @Description: 获取验证码
     * @Date: 10:11 2020/9/3
     * @Param: [response]
     * @return: void
     **/
    @GetMapping("/getCaptch")
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public void getCaptch(HttpServletResponse response) throws IOException {
        UUID uuid = idGenerator.generateId();
        String randomStr = captchaUtil.randomStr(4);
        redisService.set(uuid.toString(), randomStr, 3000);
        CaptchaUtil captchaUtil = new CaptchaUtil(116,36,4,10, randomStr);
        response.addHeader("captchKey",uuid.toString());
        captchaUtil.write(response.getOutputStream());
    }

    /**
     * @Author: yongchen
     * @Description: 用户登录
     * @Date: 12:00 2020/9/3
     * @Param: [userName, passWord, captchKey, captchCode]
     * @return: com.example.commons.api.Result
     **/
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public Result login(@RequestParam String userName,
                        @RequestParam String passWord,
                        @RequestParam String captchKey,
                        @RequestParam String captchCode){
        // 1.校验验证码是否正确
        String captchValue = (String) redisService.get(captchKey);
        if (StringUtils.isBlank(captchValue)){
            return fail("验证码已过期！");
        }
        if (!StringUtils.equals(captchValue, captchCode)){
            return fail("验证码不匹配！");
        }

        // 2.校验登录信息
        UserInfoVO infoVO = (UserInfoVO) userService.loadUserByUsername(userName);
        if (null == infoVO){
            return fail("用户名不存在!");
        }
        if (!passwordEncoder.matches(passWord, infoVO.getPassword())){
            return fail("用户密码错误，请输入正确的密码！");
        }
        String token = jwtTokenUtil.generateToken(infoVO);
        return success(token);
    }




}
