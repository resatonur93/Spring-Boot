package com.onurk.springhelloword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class HelloApi {
    @GetMapping
    public String mesaj(){
        return "Hello!";
    }
}
