package com.javahao.controller;

import com.javahao.pojo.LunBo;
import com.javahao.service.LunBoService;
import com.javahao.util.UploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
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
public class LunBoController {
    @Autowired
    private LunBoService lbs;
    @Autowired
    private UploadUtils uploadUtils;
    @Value("${qiniu.url}")
    private String url;

    @RequestMapping("/admin")
    public String show3() {
        return "index";
    }

    @RequestMapping("/feijidazhan")
    public String show10() {
        return "feijidazhan";
    }
    @RequestMapping("/show")
    public String show() {
        return "welcome";
    }
    @RequestMapping("/lunadd")
    public String show4() {
        return "lunboadd";
    }

    @RequestMapping("/lunupdate")
    public String show5() {
        return "lunboupdate";
    }
    @RequiresPermissions(value = {"find"})
    @RequestMapping("/lunfinAll")
    public ModelAndView findAll() {
        List<LunBo> list = lbs.finAll();
        ModelAndView m = new ModelAndView("lunbo");
        m.addObject("list", list);
        return m;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<LunBo>findAllQ() {
        List<LunBo> list = lbs.finAll();
        return list;
    }
    @RequiresPermissions(value = {"insert"})
    @RequestMapping("/addLunBo")
    public String addcar(@RequestParam("file") MultipartFile muli) throws UnsupportedEncodingException {
        String upload = uploadUtils.upload(muli);
        LunBo lunBo = new LunBo();
        lunBo.setLpic(url + upload);
        lbs.add(lunBo);
        return "redirect:/lunfinAll";
    }

    @RequestMapping(value = "/up/{lid}", method = RequestMethod.GET)
    public ModelAndView up(@PathVariable("lid") Integer lid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lunboupdate");
        modelAndView.addObject("lunbo", lbs.findLunBoLid(lid));
        return modelAndView;
    }
    @RequiresPermissions(value = {"update"})
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(String lid, @RequestParam("file") MultipartFile muli) throws UnsupportedEncodingException {
        LunBo lunBo = new LunBo();
        lunBo.setLid(Integer.valueOf(lid));
        String originalFilename = muli.getOriginalFilename();
        if (!originalFilename.equals("")) {
            String upload = uploadUtils.upload(muli);
            lunBo.setLpic(url + upload);
        }
        lbs.updateItems(lunBo);
        return "redirect:/lunfinAll";
    }
    @RequiresPermissions(value = {"delete"})
    @RequestMapping(value = "/del/{lid}", method = RequestMethod.GET)
    public String del(@PathVariable("lid") Integer lid) {
        lbs.deleteLunBo(lid);
        return "redirect:/lunfinAll";
    }
}
