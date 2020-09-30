package com.example.commons.annotation.login;

import java.lang.annotation.*;

/**
 * @Author: yongchen
 * @Description: 用户信息统一采集注解,在api层方法上使用此注解可以获得当前登录用户的信息
 * @Date: 11:50 2020/9/1
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectUser {
}
