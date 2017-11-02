package com.tdd.pairing;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookSearchTest {


    private BookStoreService bookStoreService;

    @Before
    public void setUp() {
        // Given the book store is open
        bookStoreService = new BookStoreService();
    }

    //Scenario 1

    @Test
    public void should_AddBooksToTheStoreTest_When_WeAddBooksToStore() {
        Book book = new Book("1","name");
        // When we try to add books
        bookStoreService.addBook(book);
        // Then books should be added to the store
        assertThat(book, is(equalTo(bookStoreService.getBook("name"))));

    }

    //Scenario 2

    @Test
    public void should_ReturnTheBooks_When_TheyAreSearchedFor() {
        // and is not empty
        Book book = new Book("2","CLeanCode");
        bookStoreService.addBook(book);
        // When we search for the books
        // and is avialable
        // then the store should return the book
        assertThat("CLeanCode", is(bookStoreService.searchBooksByName("CLeanCode").getName()));

    }


}
