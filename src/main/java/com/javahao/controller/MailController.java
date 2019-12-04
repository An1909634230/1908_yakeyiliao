package com.javahao.controller;

import com.javahao.mail.TestMail;
import com.javahao.pojo.User;
import com.javahao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MailController {
@Autowired
private UserService userService;
@Autowired
private  TestMail testMail;

    @RequestMapping("/email")
    public String shuai() throws MessagingException {
        testMail.test();
        return "/ceshiyemian";
    }

    //邮箱用
    @RequestMapping("/shuai/{uid}")
    public String mail(@PathVariable("uid") Integer uid,Model model){
        System.out.println(uid);
        User all = userService.findById(uid);
        System.out.println(all);
        model.addAttribute("all",all);
        return "/mail";
    }
}
