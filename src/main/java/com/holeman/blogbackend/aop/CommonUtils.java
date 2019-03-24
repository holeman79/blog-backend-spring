package com.holeman.blogbackend.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonUtils {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
//    @Around("execution(* com.holeman.blogbackend.post.PostController.getPostList(..))")
//    public void postListTest(ProceedingJoinPoint proceedingJoinPoint){
//        Object result = null;
//        try {
//            long start = System.currentTimeMillis();
//            result = proceedingJoinPoint.proceed();
//            long end = System.currentTimeMillis();
//
//            logger.info("수행 시간 : "+ (end - start) + "milliseconds");
//        } catch (Throwable throwable) {
//            logger.error("exception!");
//        }
//    }


    @Around("execution(* com.holeman.blogbackend.post.PostController.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        logger.info("수행 시간 : "+ (end - start) + "milliseconds");
        return result;
    }

}
