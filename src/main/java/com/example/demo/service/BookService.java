package com.example.demo.service;

import com.example.demo.Entyty.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private static final Long NOT_FOUND = -1L;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Long create(Book book){
        if (book == null){
            return NOT_FOUND;
        }
        return bookRepository.save(book).getId();
    }

    public Optional<Book> getById (Long id){
        if (id == null || id < 1) {
            return Optional.empty();
        }
        return bookRepository.findById(id);
    }

    public Long delete(Long id){
        if (id == null || id < 1) {
            return NOT_FOUND;
        }
        if (getById(id).isPresent()) {
            bookRepository.deleteById(id);
            return id;
        }
        return NOT_FOUND;
    }
}
