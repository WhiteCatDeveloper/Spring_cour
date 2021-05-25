package org.example.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aop.Book;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

//    @Pointcut("execution(* org.example.aop.UniLibrary.*(..))")
//    private void allMethodFromUniLibrary() {}
//
//    @Pointcut("execution(public void org.example.aop.UniLibrary.returnMagazine())")
//    private void returnFromUniLibrary(){}
//
//    @Pointcut("allMethodFromUniLibrary() && !returnFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary() {}
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineFromUniLibrary() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineFromUniLibrary: writing Log #10");
//    }

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


    @Before("org.example.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = "
                + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] args = joinPoint.getArgs();
            for (Object obj : args) {
                if (obj instanceof Book) {
                    Book book = (Book) obj;
                    System.out.println("Information of book: title - " +
                            book.getName() + " author - " + book.getAuthor() +
                            " yearOfPublication - " + book.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добаляет - " + obj);
                }
            }
        }

        System.out.println(
                "beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
        System.out.println("------------------------------------------");
    }




}
