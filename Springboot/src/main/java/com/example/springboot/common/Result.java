package com.example.springboot.common;

import lombok.Data;

// 统一返回结果的包装
@Data
public class Result {
    private static final String SUCCESS = "200";
    private static final String ERROR = "-1";
    // 将后台数据存到data里面
    // 接口相应数据存入code
    // msg是报错信息

    private String code;
    private Object data;
    private String msg;

    public static Result success()
    {
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }

    public static Result success(Object data)
    {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result success(String msg)
    {
        Result result = new Result();
        result.setCode(ERROR);
        result.setMsg(msg);
        return result;
    }
}
