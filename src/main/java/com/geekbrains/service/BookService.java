package com.geekbrains.service;

import com.geekbrains.entites.Book;
import com.geekbrains.repositories.BookDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDAOImpl bookDAO;


    public void saveBook(Book book){
        bookDAO.save(book);
    }

    public List<Book> getListBook(){
        return bookDAO.findAll();
    }

    public void delete(long id){
        bookDAO.delete(id);
    }

    public Book getBookById(long id){
        return bookDAO.getById(id);
    }


}
