package com.example.springboot.service.impl;

import com.example.springboot.controller.request.BookPageRequest;
import com.example.springboot.entity.Book;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.service.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 标注为spring组件供外部调用
@Service
// 调用mapper通过IBookService返回数据
public class BookService implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.list();
    }

    @Override
    public Object page(BookPageRequest bookPageRequest) {
        // 借助PageHelper插件实现分页
        PageHelper.startPage(bookPageRequest.getPageNum(),bookPageRequest.getPageSize());
        List<Book> books =  bookMapper.listByCondition(bookPageRequest);
        PageInfo<Book> bookPageInfo = new PageInfo<>(books);
        return bookPageInfo;
    }

    @Override
    public void save(Book book) {
        bookMapper.save(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.getById(id);
    }

    @Override
    public void upData(Book book) {
        bookMapper.upDataById(book);
    }
}
