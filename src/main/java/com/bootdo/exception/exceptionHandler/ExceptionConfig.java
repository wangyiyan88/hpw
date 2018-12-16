package com.bootdo.exception.exceptionHandler;

import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

public class ExceptionConfig {
    @Bean
    public GlobalExceptionHandler resultBuilder(){
        return  new GlobalExceptionHandler();
    }

}
