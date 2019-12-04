package com.javahao.controller;

import com.javahao.pojo.LunBo;
import com.javahao.pojo.Ser;
import com.javahao.service.SerService;
import com.javahao.util.UploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by anzIhao on 2019/12/3.
 */
@Controller
public class SerController {
    @Autowired
    private SerService ss;
    @Autowired
    private UploadUtils uploadUtils;
    @Value("${qiniu.url}")
    private String url;

    @RequestMapping("/serveradd")
    public String show4() {
        return "serveradd";
    }

    @RequiresPermissions(value = {"find"})
    @RequestMapping("/servicefindAll")
    public ModelAndView findAll() {
        List<Ser> list = ss.findAll();
        ModelAndView m = new ModelAndView("server");
        m.addObject("list", list);
        return m;
    }
    @RequiresPermissions(value = {"insert"})
    @RequestMapping("/addservice")
    public String addcar(@RequestParam("file") MultipartFile muli, String seintro, String sename) throws UnsupportedEncodingException {
        String upload = uploadUtils.upload(muli);
        Ser ser = new Ser();
        ser.setSepic(url + upload);
        ser.setSename(sename);
        ser.setSeintro(seintro);
        ss.add(ser);
        return "redirect:/servicefindAll";
    }
    @RequiresPermissions(value = {"delete"})
    @RequestMapping(value = "/serdel/{seid}", method = RequestMethod.GET)
    public String del(@PathVariable("seid") Integer seid) {
        ss.deleteSer(seid);
        return "redirect:/servicefindAll";
    }

    @RequestMapping(value = "/serup/{seid}", method = RequestMethod.GET)
    public ModelAndView up(@PathVariable("seid") Integer seid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("serverupdate");
        modelAndView.addObject("ser", ss.findSerseid(seid));
        return modelAndView;
    }
    @RequiresPermissions(value = {"update"})
    @RequestMapping(value = "/serupdate", method = RequestMethod.POST)
    public String update(String seid, @RequestParam("file") MultipartFile muli, String seintro, String sename) throws UnsupportedEncodingException {
        Ser ser = new Ser();
        ser.setSeid(Integer.valueOf(seid));
        ser.setSeintro(seintro);
        ser.setSename(sename);
        String originalFilename = muli.getOriginalFilename();
        if (!originalFilename.equals("")) {
            String upload = uploadUtils.upload(muli);
            ser.setSepic(url + upload);
        }
       ss.updateSer(ser);
        return "redirect:/servicefindAll";
    }
    @RequestMapping("/serfindAll")
    @ResponseBody
    public List<Ser>findAllQ() {
        List<Ser> list = ss.findAll();
        return list;
    }

}
