package com.br.edercnj.aspectlog.annotation;

import com.br.edercnj.aspectlog.enumeration.HttpMethod;
import com.br.edercnj.aspectlog.enumeration.LogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRestMessage {

    LogType logType() default LogType.HTTP_MESSAGE;
    HttpMethod[] httpMethods() default {HttpMethod.GET, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST, HttpMethod.PATCH};
    String preExecuteMessage() default "";

}
