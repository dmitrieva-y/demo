package com.example.demo.controeller;

import com.example.demo.Entyty.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class BookController {


    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getAllBook() {
        return bookService.getAll();
    }

    @GetMapping(value = "/auth/{id}")
    public Book getBookById(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Book book = bookService.getById(id);
        if (book == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        return book;
    }

    @GetMapping(value = "/admin/delete/{id}")
    public Long delete(@PathVariable Long id, HttpServletResponse response) throws IOException {
        if (bookService.delete(id)< 0){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        return id;
    }

    @GetMapping("/admin/create")
    public Long create(@ModelAttribute Book book, HttpServletResponse response) throws IOException {
        Long id = bookService.create(book);
        if(id < 0){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return id;
    }
  }
