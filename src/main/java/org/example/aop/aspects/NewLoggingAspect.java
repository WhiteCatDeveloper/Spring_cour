package org.example.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(
                "aroundAdvice: в библиотеку пытаются вернуть книгу"
        );

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundAdvice: поймано исключение - " + e);
            throw e;
        }

        System.out.println(
                "aroundAdvice: в библиотеку успешно возвращают книгу"
        );
        return targetMethodResult;
    }
}
