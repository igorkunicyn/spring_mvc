package com.geekbrains.controllers;

import com.geekbrains.entites.Book;
import com.geekbrains.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public ModelAndView viewHomePage(ModelAndView model) {
        List<Book> listBooks = bookService.getListBook();
        model.addObject("listBooks", listBooks);
        model.setViewName("book-list");
        return model;
    }

    @RequestMapping("/new")
    public ModelAndView createNewBook(ModelAndView model) {
        Book book = new Book();
        model.addObject("book", book);
        model.setViewName("new-book");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return new ModelAndView("redirect:/book/");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable(name = "id") long id) {
        bookService.delete(id);
        return new ModelAndView("redirect:/book/");
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBook(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit-book");
        Book book = bookService.getBookById(id);
        modelAndView.addObject("book", book);
        return modelAndView;
    }

}