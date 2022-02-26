package com.adilmx.aopcustomannotations.aspect;

import com.adilmx.aopcustomannotations.annotation.CustomSecurity;
import com.adilmx.aopcustomannotations.context.CustomSecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CustomSecurityAspect {
    @Autowired
    CustomSecurityContext securityContext;

    @Around(value = "@annotation(customSecurity)",argNames = "proceedingJoinPoint,customSecurity")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint, CustomSecurity customSecurity) {
        System.out.println("*************SECURITY ASPECT START************************");
        Object object = 0;
        String[] roles = customSecurity.role();
        int authorized = securityContext.hasRole(roles);
        if (authorized == 1) {
            try {
                object = proceedingJoinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException("OPERATION FAILED!");
            }
        }else{
            throw new RuntimeException("USER NOT AUTHORISED FOR THIS OPERATION!");
        }

        System.out.println("*************SECURITY ASPECT END************************");
        return object;
    }

    /*
    @AfterReturning //after getting result
    @AfterThrowing //handle errors
    and others
    */
}
