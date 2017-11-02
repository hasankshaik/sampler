package com.tdd.pairing;

public final class Book {

    private final String id;
    private final String name;

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}