package com.javahao.controller;


import com.javahao.pojo.User;
import com.javahao.service.UserService;
import com.javahao.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/log")
    public String login(@RequestBody User user, Model model, HttpServletRequest request){
        String name=user.getUname();
        String pass=user.getUpass();
        Map map=new HashMap();
        map.put("name",name);
        map.put("pass",pass);
        User user1=userService.selectByNameAndPass(name,pass);
        if(user1!=null){
            //用户存在，往session里面存储用户
            request.getSession().setAttribute(ConstantUtils.USER_SESSION_KEY,user);
            return "success";
        }else{
            model.addAttribute("ErrMsg","用户名与密码不匹配");
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
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute(ConstantUtils.USER_SESSION_KEY);
        return "success";
    }
}
