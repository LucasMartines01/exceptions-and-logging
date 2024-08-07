package com.br.lucassilvamartines.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ExceptionLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionLoggingAspect.class);

    @Pointcut("@within(EnableLogging) || @annotation(EnableLogging)")
    public void enableLoggingPointcut() {}

    @Around("enableLoggingPointcut()")
    public Object logException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Throwable ex) {
            logger.error("Exception occurred in method {}: {}", joinPoint.getSignature(), ex.getMessage(), ex);
            throw ex;
        }
    }
}