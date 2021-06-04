package com.geekbrains;

import com.geekbrains.entites.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    void save(Book book);
    void delete(long id);
    Book getById(long id);
}
