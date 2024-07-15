package org.example.booklambda;

import java.util.*;

public class BookDAO {

    public static List<Book> getAllBooks(){
        return  Arrays.asList(
                new Book(101, "Core java", 100),
                new Book(102,"Spring",200),
                new Book(103, "Microservices", 300)
        );
    }
    public static List<Book> getBooksinSortingOrder(){
        List<Book> books = getAllBooks();
         //Collections.sort(books , new Mycomparater());
        /*Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book book1,Book book2) {
                return book2.getBname().compareTo(book1.getBname());
            }
        });*/


        Collections.sort(books, (b1 ,b2)->b2.getBname().compareTo(b1.getBname()));
         return books;
    }

    public static void main(String[] args) {
        System.out.println(getBooksinSortingOrder());
    }
}

/*
class Mycomparater implements Comparator<Book>{

    @Override
    public int compare(Book book1, Book book2) {
        return book1.getBname().compareTo(book2.getBname());
    }
}*/
