package org.example.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println(
                "Мы берем книгу из UniLibrary ");
    }

    public void returnBook() {
        System.out.println("Возвращаем книгу");
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
    }

    public void returnMagazine() {
        System.out.println("Возвращаем журнал");
    }

    public void addBook() {
        System.out.println("Добавляем книгу");
    }

    public void addMagazine() {
        System.out.println("Добавляем журнал");
    }
}
