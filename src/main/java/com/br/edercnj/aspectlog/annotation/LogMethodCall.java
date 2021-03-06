package com.br.edercnj.aspectlog.annotation;

import com.br.edercnj.aspectlog.enumeration.LogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogMethodCall {

    LogType logType() default LogType.METHOD_CALL;
    String preExecuteMessage() default "";
}
