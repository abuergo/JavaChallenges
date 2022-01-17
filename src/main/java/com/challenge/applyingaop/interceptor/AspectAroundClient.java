package com.challenge.applyingaop.interceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AspectAroundClient {
    Logger LOGGER = LogManager.getLogger(AspectAroundClient.class);

    @Pointcut("execution(* com.challenge.applyingaop.service.ClientService.*(..))" + "&& !execution(* com.challenge.applyingaop.service.ClientService.deleteClient(..))")
    void servicesClassMethods(){}

    @Around("servicesClassMethods()")
    void aroundAdviceMethod(ProceedingJoinPoint jp) throws Throwable{
        LOGGER.info("Around method starts executing");
        long start = System.nanoTime();
        jp.proceed();
        long end = System.nanoTime();
        String className = jp.getTarget().getClass().getName();
        LOGGER.info("The method of the pointcut is inside the class" + className);
        LOGGER.info("Method was executed with a duration of {} ms", TimeUnit.NANOSECONDS.toMillis(end - start));
    }
}
