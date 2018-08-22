package com.entity;

public class Book {
    int id;
    String name;
    float price;
    String writter;

    public Book(int id, String name, float price, String writter) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.writter = writter;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }
}
