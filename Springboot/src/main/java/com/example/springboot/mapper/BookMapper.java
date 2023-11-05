package com.example.springboot.mapper;

import com.example.springboot.controller.request.BookPageRequest;
import com.example.springboot.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
// 能够调用来操作数据库的一些方法
public interface BookMapper {

    // 用select注解实现数据库的查询
    // 如果通过xml，就不用这种形式
//    @Select("select * from book")
    // service业务处理层调用该方法
    // 将数据映射到ListBooks中去
    List<Book> list();

    List<Book> listByCondition(BookPageRequest bookPageRequest);

    void save(Book book);

    Book getById(Integer id);

    void upDataById(Book book);
}
