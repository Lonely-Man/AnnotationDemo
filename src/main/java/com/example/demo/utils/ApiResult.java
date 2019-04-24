package com.example.demo.utils;

import lombok.Data;

@Data
public class ApiResult<T> {
    private String code;
    private String msg;
    private T data ;
    public static<T> ApiResult<T> result(String code,String msg,T data){
        ApiResult result= new ApiResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
