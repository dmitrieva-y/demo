package com.example.demo.Entyty;

import java.util.Objects;

public class Book {
    private static Long count = 0L;
    private Long id;
    private String bookName;
    private String author;
    private Integer year;
    private String noJsonData;
    private String nullData;

    public Book() {
        ++count;
    }

    public Book(String bookName, String author, Integer year) {
        this.id = ++count;
        this.bookName = bookName;
        this.author = author;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNoJsonData() {
        return noJsonData;
    }

    public void setNoJsonData(String noJsonData) {
        this.noJsonData = noJsonData;
    }

    public String getNullData() {
        return nullData;
    }

    public void setNullData(String nullData) {
        this.nullData = nullData;
    }

    public static Long getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", noJsonData='" + noJsonData + '\'' +
                ", nullData='" + nullData + '\'' +
                '}';
    }
}
