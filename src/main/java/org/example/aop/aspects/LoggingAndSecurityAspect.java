package org.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* org.example.aop.UniLibrary.*(..))")
    private void allMethodFromUniLibrary() {}

    @Pointcut("execution(public void org.example.aop.UniLibrary.returnMagazine())")
    private void returnFromUniLibrary(){}

    @Pointcut("allMethodFromUniLibrary() && !returnFromUniLibrary()")
    private void allMethodsExceptReturnMagazineFromUniLibrary() {}

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsExceptReturnMagazineFromUniLibrary() {
        System.out.println("beforeAllMethodsExceptReturnMagazineFromUniLibrary: writing Log #10");
    }

//
//@Pointcut("execution(* org.example.aop.UniLibrary.get*())")
//    private void allGetMethodsUniLibrary(){}
//
//    @Pointcut("execution(* org.example.aop.UniLibrary.return*())")
//    private void allReturnMethodsUniLibrary(){}
//
//    @Pointcut("allGetMethodsUniLibrary() || allReturnMethodsUniLibrary()")
//    private void allGetAndReturnMethodsUniLibrary() {}
//
//
//@Before("allGetMethodsUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//    System.out.println(
//            "beforeGetLoggingAdvice: writing Log #1"
//    );
//}
//
//    @Before("allReturnMethodsUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println(
//                "beforeReturnLoggingAdvice: writing Log #2"
//        );
//    }
//
//    @Before("allGetAndReturnMethodsUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println(
//                "beforeGetAndReturnLoggingAdvice: writing Log #3"
//        );
//    }


//    @Pointcut("execution(* get*())")
//    private void allGetMethods(){}
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println(
//                "beforeGetLoggingAdvice: попытка получить книгу/журнал");
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice: проверка на получение" +
//                " книги/журнала");
//
//    }


}
