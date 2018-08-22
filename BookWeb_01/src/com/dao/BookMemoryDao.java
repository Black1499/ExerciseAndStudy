package com.dao;

import com.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMemoryDao implements BookDao {
    private static List<Book> bookList =new ArrayList<Book>();

    static{
        bookList.add(new Book(1,"战争与和平",99.9f,"托尔斯泰"));
        bookList.add(new Book(2,"百年孤独",89.9f,"高尔基"));
        bookList.add(new Book(3,"钢铁",79.9f,"屠格涅夫斯基"));
        bookList.add(new Book(4,"三体",69.9f,"刘慈溪"));
        bookList.add(new Book(5,"和平",59.9f,"托尔斯泰"));

    }

    @Override
    public List<Book> getAll() {
        return bookList;
    }

    @Override
    public Book getBookById(int id) {
        for (Book book : bookList) {
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getBookByName(String name) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : bookList) {
            String realName = book.getName().toLowerCase();
            if (realName.contains(name.toLowerCase())) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public boolean addBook(Book b) {
        return bookList.add(b);
    }

    @Override
    public boolean dleBook(int id) {
        for (Book book : bookList) {
            if(book.getId()==id){
                return bookList.remove(book);
            }

        }
        return false;
    }

    @Override
    public boolean updBook(Book b) {
        for (Book book : bookList) {
            if(book.getId()==b.getId()){
                book.setName(b.getName());
                book.setPrice(b.getPrice());
                book.setWritter(b.getWritter());
                return true;
            }
        }
        return false;
    }
}
