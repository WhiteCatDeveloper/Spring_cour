package org.example.aop;

import org.example.aop.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("Мы берем книгу из SchoolLibrary");
    }
}
