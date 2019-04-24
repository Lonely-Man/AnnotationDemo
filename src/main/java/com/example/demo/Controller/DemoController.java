package com.example.demo.Controller;

import com.example.demo.utils.ApiResult;
import com.example.demo.utils.User;
import com.example.demo.utils.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo")
    @demo(value = "demo",isDemo = false)
    public ApiResult demo(){
        User user=null;
        user.getName();
        System.out.println("test");
        return ApiResult.result(
                "1","成功","");
    }
}
