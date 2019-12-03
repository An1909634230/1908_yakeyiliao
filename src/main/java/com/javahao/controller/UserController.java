package com.javahao.controller;


import com.javahao.pojo.User;
import com.javahao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/log")
    public String login(@RequestBody User user){
        String name=user.getUname();
        String pass=user.getUpass();

        try{
            userService.selectByNameAndPass(name,pass);
            return "success";
        }catch(Exception e){

        }

        return "failure";
    }
    @RequestMapping("/selectall")
    public List<User> selectall(){
        List<User> list=userService.selectAll();
        return list;

    }

    @RequestMapping("/insert")
    public String insert(@RequestBody User user){
        try{
            userService.insert(user);
            return "success";
        }catch(Exception e){

        }

        return "failure";

    }

    @RequestMapping("/findOne")
    public String findOne(@RequestBody User user){
        Integer id=user.getUid();
        try{
            userService.findById(id);
            return "success";
        }catch(Exception e){

        }

        return "failure";

    }

    @RequestMapping("/update")
    public String update(@RequestBody User user){

        try{
            userService.update(user);
            return "success";
        }catch(Exception e){

        }

        return "failure";

    }

    @RequestMapping("/delete")
    public String delete(@RequestBody User user){
        Integer id=user.getUid();
        try{
            userService.delete(id);
            return "success";
        }catch(Exception e){

        }

        return "failure";

    }
}
