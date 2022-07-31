package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @RequestMapping("/json1")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        //将对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();

        User user = new User("宝藏男孩", 10, "男");
        System.out.println(user);

        //将java 对象转换成json字符串
        String str = mapper.writeValueAsString(user);
        System.out.println(str);

        //由于使用了@Responsebody,会将str以json格式的字符串返回
        return str;
    }
    @RequestMapping(value = "/json2",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        User user = new User("宝藏男孩", 10, "男");
        return new ObjectMapper().writeValueAsString(user);
    }

    @RequestMapping(value = "/json3",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        String format = sdf.format(date);
        return new ObjectMapper().writeValueAsString(format);
    }
}
