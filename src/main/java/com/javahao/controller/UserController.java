package com.javahao.controller;


import com.javahao.pojo.User;
import com.javahao.service.UserService;
import com.javahao.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anzIhao on 2019/12/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping("/userfindAll")
//    public ModelAndView findAlla() {
//        List<User> list = userService.selectAll();
//        ModelAndView m = new ModelAndView("user");
//        m.addObject("list", list);
//        return m;
//    }


    @RequestMapping("/selectall")
    @ResponseBody
    public List<User> selectall() {
        List<User> list = userService.selectAll();
        return list;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody User user) {
        String to=user.getEmail();
        try {
            userService.insert(user);
            userService.SendSimpleMail(to);
            return "success";
        } catch (Exception e) {

        }
        return "failure";
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public String findOne(@RequestBody User user) {
        Integer id = user.getUid();
        try {
            userService.findById(id);
            return "success";
        } catch (Exception e) {
        }
        return "failure";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user) {
        System.out.println(user);
        try {
            userService.update(user);
            return "success";
        } catch (Exception e) {
        }
        return "failure";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody User user) {
        Integer id = user.getUid();
        try {
            userService.delete(id);
            return "success";
        } catch (Exception e) {
        }
        return "failure";
    }
    @RequestMapping(value = "/sendmail", method = RequestMethod.POST)
    @ResponseBody
    public String sendmail(@RequestBody User user){

        String to=user.getEmail();
        try{
            userService.SendSimpleMail(to);
            return "success";
        }catch(Exception e){
            System.out.println("forbiden");
        }

        return "failee";
    }
}
