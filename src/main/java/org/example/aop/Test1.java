package org.example.aop;

import org.example.aop.aspects.SchoolLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        MyConfig.class
                );
//        Book book = context.getBean("book", Book.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
         uniLibrary.getBook();
         uniLibrary.returnMagazine();
         uniLibrary.addBook();


        SchoolLibrary schoolLibrary = context.getBean(
                "schoolLibrary", SchoolLibrary.class
        );
//        schoolLibrary.getBook();

        context.close();
    }
}