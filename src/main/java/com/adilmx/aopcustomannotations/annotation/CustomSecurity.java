package com.adilmx.aopcustomannotations.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* ANNOTATION FOR RUNTIME (TO BE USED BY SPRING AOP) */
@Retention(RetentionPolicy.RUNTIME)
/* THE TARGET OF THE ANNOTATION (METHOD) */
@Target(ElementType.METHOD)
public @interface CustomSecurity {
    String[] role();
}
