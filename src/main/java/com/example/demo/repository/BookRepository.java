package com.example.demo.repository;

import com.example.demo.Entyty.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {
    private static List<Book> books;
    private static final Long NOT_FOUND = -1L;

    public BookRepository() {
        books = new ArrayList<>();
        books.add(new Book("Book", "Ivanov", 2002));
        books.add(new Book("Stop", "Petrov", 1997));
        books.add(new Book("Book2", "Ivank", 1963));
        books.add(new Book("City", "Smirnoff", 2000));
    }

    public List<Book> getAll() {
        return books;
    }

    public Book getById(Long id) {
        return books.stream().filter(book -> Objects.equals(book.getId(), id)).findAny().orElse(null);
    }

    public Long delete(Long id) {
        Book book = getById(id);
        if (book == null) {
            return NOT_FOUND;
        }
        books.remove(book);
        return id;
    }

    public Long create(Book book) {
        book.setId(Book.getCount());
        books.add(book);
        return book.getId();
    }
}
