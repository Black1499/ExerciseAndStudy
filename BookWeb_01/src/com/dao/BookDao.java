package com.dao;

import com.entity.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAll();
    Book getBookById(int id);
    List<Book> getBookByName(String name);

    boolean addBook(Book b);
    boolean dleBook(int id);
    boolean updBook(Book b);

}
