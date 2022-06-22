package com.example.demo.service;

import com.example.demo.Entyty.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private static final Long NOT_FOUND = -1L;
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Long create(Book book){
        if (book == null){
            return NOT_FOUND;
        }
        return bookRepository.create(book);
    }

    public Book getById (Long id){
        if (id == null || id < 1) {
            return null;
        }
        return bookRepository.getById(id);
    }

    public Long delete(Long id){
        if (id == null || id < 1) {
            return NOT_FOUND;
        }
        return bookRepository.delete(id);
    }
}
