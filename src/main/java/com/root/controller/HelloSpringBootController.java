package com.root.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloSpringBootController {
    @RequestMapping("/index")
    public String hello(){
        return "hello springBoot";
    }

    @RequestMapping("/hello")
    public Map<String,String> getMap(){
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("key1","姓名");
        map.put("key2","年龄");
        map.put("key3","性别");
        return map;
    }

}
