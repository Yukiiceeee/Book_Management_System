package com.example.springboot.entity;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String name;
    private String writer;
    private Integer amount;
    private String category;
    private String register;
    private String number;
}
