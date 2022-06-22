package com.example.demo.controeller;

import com.example.demo.Entyty.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {


    private final BookService bookService;

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
        Optional<Book> book = bookService.getById(id);
        if (!book.isPresent()){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        return  book.orElseThrow(() -> new RuntimeException("Not found book with id : " + id));
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
