package com.challenge.applyingaop.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAfterClient {
    Logger LOGGER = LogManager.getLogger(AspectAfterClient.class);

    // All methods that have CustomMethodAnnotation will be marked as a pointcut
    @Pointcut("@annotation(com.challenge.applyingaop.annotations.CustomMethodAnnotation)")
    void updateDeleteClient(){
    }

    @After("updateDeleteClient()")
    void afterUpdateDelete(){
        LOGGER.info("This log is executed after method update client or delete client");
    }

    @AfterThrowing("execution(* com.challenge.applyingaop.service.ClientService.*(..))")
    void afterThrowingAdviceMethod(){
        LOGGER.info("This log is executed if there was an exception executing any method of ClientService class");
    }
}
