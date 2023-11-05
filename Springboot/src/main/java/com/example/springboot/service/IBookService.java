package com.example.springboot.service;

import com.example.springboot.controller.request.BookPageRequest;
import com.example.springboot.entity.Book;

import java.util.List;

public interface IBookService {

    List<Book> list();

    Object page(BookPageRequest bookPageRequest);

    void save(Book book);

    Book getById(Integer id);

    void upData(Book book);
}
