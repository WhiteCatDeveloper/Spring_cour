package org.example.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary ");
        System.out.println("------------------------------------------");
    }

    public String returnBook()  {
        int a = 10/0;
        System.out.println("Возвращаем книгу");
        return "Война и мир";
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
        System.out.println("------------------------------------------");
    }

    public void returnMagazine() {
        System.out.println("Возвращаем журнал");
        System.out.println("------------------------------------------");
    }

    public void addBook(String personName, Book book) {
        System.out.println("Добавляем книгу");
        System.out.println("------------------------------------------");
    }

    public void addMagazine() {
        System.out.println("Добавляем журнал");
        System.out.println("------------------------------------------");
    }
}
