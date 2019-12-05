package com.javahao.controller;


import com.javahao.pojo.User;
import com.javahao.service.UserService;
import com.javahao.util.ConstantUtils;
import com.javahao.util.memberNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anzIhao on 2019/12/2.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectall")
    public List<User> selectall() {
        List<User> list = userService.selectAll();
        return list;
    }

    /*用户预约，添加用户*/
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody User user) {
        //获得会员号
        String number = memberNumberUtils.memberNumberUtils();
        user.setMember(number);
        user.setMoney(0.0);
        String to = user.getEmail();
        String name=user.getUname();
        try {
            userService.insert(user);
            userService.SendSimpleMail(to, number,name);
            return "success";
        } catch (Exception e) {
        }
        return "failure";
    }

    @RequestMapping("/findOne")
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
    public String delete(@RequestBody User user) {
        Integer id = user.getUid();
        try {
            userService.delete(id);
            return "success";
        } catch (Exception e) {
        }
        return "failure";
    }

    //查询会员是否存在
    @RequestMapping("findByMember/{event}")
    public String findByMember(@PathVariable("event") String member) {
        String member1 = userService.findByMember(member);
        System.out.println(member1);
        return member1;
    }
}
