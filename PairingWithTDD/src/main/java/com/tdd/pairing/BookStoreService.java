package com.tdd.pairing;

import java.util.ArrayList;
import java.util.List;

public class BookStoreService {

    private final static List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getBook(String name) {
        return books.stream().filter(b->b.getName().equals(name)).findFirst().get();
    }

    public Book searchBooksByName(String name) {
        return books.stream().filter(b->b.getName().equals(name)).findFirst().get();
    }
}
