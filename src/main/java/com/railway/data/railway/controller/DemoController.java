package com.railway.data.railway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: railway
 * @description: demo
 * @author: lijiwen
 * @create: 2019-11-06 16:54
 **/
@Controller
@RequestMapping("api/demo")
public class DemoController {
    @GetMapping("hello")
    @ResponseBody
    public String demo() {
        return "hello word";
    }

}
