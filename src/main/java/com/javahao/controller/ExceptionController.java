package com.javahao.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 54110 on 2019/11/22.
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = AuthorizationException.class)
    @RequestMapping("/yichang")
    public String excepiton() {
        return "noquanxian";
    }
}
