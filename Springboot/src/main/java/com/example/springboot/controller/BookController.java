package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.BookPageRequest;
import com.example.springboot.entity.Book;
import com.example.springboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 处理跨域问题
@CrossOrigin
// 以json形式返回数据
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;

    // save接口用来将新书入库的数据返回到数据库
    @PostMapping("/save")
    public Result save(@RequestBody Book book) {
        bookService.save(book);
        return Result.success();
    }

    // upData更新接口用来实现表单数据的更新
    @PutMapping("/upData")
    public Result upData(@RequestBody Book book) {
        bookService.upData(book);
        return Result.success();
    }

    // 通过getById接口来获取id，通过id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        return Result.success(book);
    }

    // 首先用户请求数据到GetMapping接口
    // 再通过bookService返回的数据
    // 在9090/book/list下显示出来一个json，就可以给到前端，让前端显示了
    @GetMapping("/list")
    // 用result包装返回结果
    public Result list() {
        List<Book> books = bookService.list();
        // 将books存入data里面
        return Result.success(books);
    }

    @GetMapping("/page")
    // 用result包装返回结果
    public Result page(BookPageRequest bookPageRequest) {
        return Result.success(bookService.page(bookPageRequest));
    }


}
