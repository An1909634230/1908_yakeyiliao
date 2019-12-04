package com.javahao.controller;


import com.javahao.pojo.Ser;
import com.javahao.pojo.UserHou;
import com.javahao.service.UserHouService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by anzIhao on 2019/12/4.
 */
@Controller
public class UserHouController {
    @Autowired
    private UserHouService us;
    @RequiresPermissions(value = {"find"})
    @RequestMapping("/userfindAll")
    public ModelAndView findAll() {
        List<UserHou> list = us.findAll();
        ModelAndView m = new ModelAndView("user");
        m.addObject("list", list);
        return m;
    }


    @RequestMapping("/useradd")
    public String show4() {
        return "useradd";
    }
    @RequiresPermissions(value = {"insert"})
    @RequestMapping("/adduser")
    public String addcar(String uname, String email, String tel, String data, String symptom) throws ParseException {
        UserHou userHou = new UserHou();
        userHou.setUname(uname);
        userHou.setEmail(email);
        userHou.setTel(tel);
        userHou.setData(new SimpleDateFormat("yyyy-MM-dd").parse(data));
        userHou.setSymptom(symptom);
        us.add(userHou);
        return "redirect:/userfindAll";
    }


    @RequestMapping(value = "/userup/{uid}", method = RequestMethod.GET)
    public ModelAndView up(@PathVariable("uid") Integer uid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userupdate");
        modelAndView.addObject("user", us.findUserHouByUid(uid));
        return modelAndView;
    }
    @RequiresPermissions(value = {"update"})
    @RequestMapping(value = "/userupdate", method = RequestMethod.POST)
    public String update(String uid,String uname, String email, String tel, String data, String symptom) throws ParseException {
        UserHou userHou = new UserHou();
        userHou.setUid(Integer.valueOf(uid));
        userHou.setUname(uname);
        userHou.setEmail(email);
        userHou.setTel(tel);
        userHou.setData(new SimpleDateFormat("yyyy-MM-dd").parse(data));
        userHou.setSymptom(symptom);
        us.updateUserHou(userHou);
        return "redirect:/userfindAll";
    }

    @RequiresPermissions(value = {"delete"})
    @RequestMapping(value = "/userdel/{uid}", method = RequestMethod.GET)
    public String del(@PathVariable("uid") Integer uid) {
        us.deleteUserHou(uid);
        return "redirect:/userfindAll";
    }
}
