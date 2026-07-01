package com.amanna.service;

import com.amanna.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    //setters
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter injection");
    }

    //parametrized constructor
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor called !");
    }

    //default constructor
    public BookService(){
        System.out.println("Default");
    }
}
