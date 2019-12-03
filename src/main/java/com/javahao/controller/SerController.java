package com.javahao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by anzIhao on 2019/12/3.
 */
@Controller
public class SerController {
    @RequestMapping("/server")
    public String serverShow(){
        return "server";
    }
}
