package com.example.demo.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class demoConfig {
    @Autowired
    protected HttpServletRequest httpRequest;
    @Around("@annotation(com.example.demo.utils.demo)")
    public Object demoTest(ProceedingJoinPoint point){
        System.out.println("around---------->");
        try {
            String token=httpRequest.getHeader("token");
            if(org.springframework.util.StringUtils.isEmpty(token)){
                return ApiResult.result(
                        "-1","没有凭证","");
            }
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method=signature.getMethod();
            demo d = method.getAnnotation(demo.class);
            System.out.println(d.value());
            System.out.println("");
            return point.proceed();
        }catch (Throwable e){
            e.printStackTrace();
            return ApiResult.result(
                    "-1","系统异常","");
        }

        //return "777777777";
    }
    /*@Pointcut("@annotation(demo1)")
    public void serviceStatistics(demo demo1) {
        System.out.println("point----------------->");
    }

    @Before("serviceStatistics(demo1)")
    public Object doBefore(JoinPoint joinPoint, demo demo1) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method =signature.getMethod();
        demo demo1=method.getAnnotation(demo.class);
        demo1.value();
        System.out.println(demo1.value());
        System.out.println("before");

        return "";
    }

    @After("serviceStatistics(demo1)")
    public void doAfter(JoinPoint joinPoint,demo demo1) {
        System.out.println("after----------->");
    }*/

}
