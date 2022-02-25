package com.adilmx.aopcustomannotations.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {
    /*@Before("execution(public double getTotalPrice(..))")
    public void log(){
        System.out.println("log aspect (before)");
    }*/
    @Around("execution(public double getTotalPriceTax(..))")
    public Object logExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Log without annotation start-----------------------------------------------------------");
        LocalDateTime dateBeforeTime = LocalDateTime.now();
        System.out.println("log aspect (before method <<"+proceedingJoinPoint.getSignature()+">> at "+dateBeforeTime);
        Object o = proceedingJoinPoint.proceed();
        LocalDateTime dateAfterTime = LocalDateTime.now();
        System.out.println("log aspect (after method <<"+proceedingJoinPoint.getSignature()+">> at "+dateAfterTime);
        System.out.println("Log without annotation end--------------------------------------------------------------");
        return o;
    }
    @Around("@annotation(com.adilmx.aopcustomannotations.annotation.Log)")
    public Object logAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Log annotation start-------------------------------------------------------------------");
        LocalDateTime dateBeforeTime = LocalDateTime.now();
        System.out.println("log aspect (before method <<"+proceedingJoinPoint.getSignature()+">> at "+dateBeforeTime);
        Object o = proceedingJoinPoint.proceed();
        LocalDateTime dateAfterTime = LocalDateTime.now();
        System.out.println("log aspect (after method <<"+proceedingJoinPoint.getSignature()+">> at "+dateAfterTime);
        System.out.println("Log annotation end-----------------------------------------------------------------------");
        return o;
    }

}
