package com.example.commons.annotation.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName: AnnotaionSysLog
 * @Description: 自定义注解执行器,统一日志处理切面
 * @Author: yongchen
 * @Date: 2020/8/31 10:50
 **/
@Slf4j
@Component
@Aspect
public class AnnotaionSysLog {

    /**
     * 配置织入点
     **/
    @Pointcut("@annotation(com.example.commons.annotation.log.SysLog)")
    public void sysLogAspect() {
    }

    @AfterReturning(pointcut = "sysLogAspect()", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint, Object ret){
        handleLog(joinPoint, null, ret);
    }

    @AfterThrowing(pointcut = "sysLogAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e){
        handleLog(joinPoint, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        long startTime = System.currentTimeMillis();
        SysLog sysLog = null;
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            sysLog = method.getAnnotation(SysLog.class);
        }

        if (sysLog == null){
            return;
        }




    }
}
