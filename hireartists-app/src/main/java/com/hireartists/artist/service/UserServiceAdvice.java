package com.hireartists.artist.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by prayagupd on 7/15/15.
 */

@Aspect
public class UserServiceAdvice {
    Logger logger = LoggerFactory.getLogger(UserServiceAdvice.class);

    @Before("execution(public User com.hireartists.artist.service.impl.UserServiceImpl.login(..))")
    public void logLogin(JoinPoint method){
        logger.info("================================================");
        logger.info(method.getArgs()[0] + " is logging in.");
        logger.info("================================================");
    }
}
