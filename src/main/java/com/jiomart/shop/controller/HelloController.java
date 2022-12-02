package com.jiomart.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String sendHello(){
        return "Hello";
    }
//    @GetMapping("/hello")
//    public String helloParam(@RequestParam String name){
//        if (name == null)
//            return "Hello there !";
//        else{
//            return "Hello "+ name;
//        }
//    }
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello " + name;
    }

}
