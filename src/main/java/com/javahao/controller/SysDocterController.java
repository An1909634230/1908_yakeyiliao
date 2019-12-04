package com.javahao.controller;

import com.javahao.pojo.DocterShiro;
import com.javahao.service.SysDoctroService;
import com.javahao.util.UploadUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by anzIhao on 2019/12/4.
 */
@Controller
public class SysDocterController {
    @Autowired
    private SysDoctroService sds;
    @Autowired
    private UploadUtils uploadUtils;
    @Value("${qiniu.url}")
    private String url;

    @RequestMapping("/login")
    public String dealLogin(DocterShiro docterShiro) {
        String name = docterShiro.getDname();
        String password = docterShiro.getPassword();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()) {
                return "redirect:/admin";
            }
        } catch (Exception e) {
        }
        return "redirect:/log";
    }

    @RequestMapping("/log")
    public String log() {
        return "login";
    }

    @RequiresPermissions(value = {"find"})
    @RequestMapping("/adminfindAll")
    public ModelAndView findAll() {
        List<DocterShiro> list = sds.findAll();
        ModelAndView m = new ModelAndView("admin");
        m.addObject("list", list);
        return m;
    }

    @RequestMapping("/addadmin")
    public String show4() {
        return "adminadd";
    }

    @RequestMapping("/yishengadd")
    public String show5() {
        return "yishengadd";
    }


    @RequiresPermissions(value = {"insert"})
    @RequestMapping("/admininsert")
    public String addcar(String dname, String password, String zhuangtai, String juese) {
        DocterShiro docterShiro = new DocterShiro();
        if (zhuangtai.equals("超级管理员")) {
            docterShiro.setZhuangtai(1);
        }
        if (zhuangtai.equals("普通查询")) {
            docterShiro.setZhuangtai(2);
        }
        docterShiro.setDname(dname);
        docterShiro.setJuese(juese);
        docterShiro.setPassword(password);
        sds.add(docterShiro);
        return "redirect:/adminfindAll";
    }

    @RequestMapping(value = "/adminup/{did}", method = RequestMethod.GET)
    public ModelAndView up(@PathVariable("did") Integer did) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminupdate");
        modelAndView.addObject("doctro", sds.findDoctroBydid(did));
        return modelAndView;
    }

    @RequiresPermissions(value = {"update"})
    @RequestMapping("/adminupdate")
    public String update(String did, String dname, String password, String zhuangtai, String juese) {
        DocterShiro docterShiro = new DocterShiro();
        if (zhuangtai.equals("超级管理员")) {
            docterShiro.setZhuangtai(1);
        }
        if (zhuangtai.equals("普通查询")) {
            docterShiro.setZhuangtai(2);
        }
        docterShiro.setDid(Integer.valueOf(did));
        docterShiro.setDname(dname);
        docterShiro.setJuese(juese);
        docterShiro.setPassword(password);
        sds.updateSer(docterShiro);
        return "redirect:/adminfindAll";
    }

    @RequiresPermissions(value = {"delete"})
    @RequestMapping(value = "/admindel/{did}", method = RequestMethod.GET)
    public String del(@PathVariable("did") Integer did) {
        sds.deleteSer(did);
        return "redirect:/adminfindAll";
    }


    @RequestMapping("/doctorfindAll")
    public ModelAndView findAlld() {
        List<DocterShiro> list = sds.findAll();
        ModelAndView m = new ModelAndView("yisheng");
        m.addObject("list", list);
        return m;
    }


    @RequestMapping("/addyishen")
    public String addyisheng(String shijian, String biaoti, String dname, String intro, String intros, String honor, String source, @RequestParam("file") MultipartFile muli) throws UnsupportedEncodingException {
        String upload = uploadUtils.upload(muli);
        DocterShiro docterShiroa = new DocterShiro();
        docterShiroa.setDname(dname);
        docterShiroa.setDpic(url + upload);
        docterShiroa.setIntro(intro);
        docterShiroa.setIntros(intros);
        docterShiroa.setHonor(honor);
        docterShiroa.setSource(source);
        docterShiroa.setBiaoti(biaoti);
        docterShiroa.setShijian(shijian);
        docterShiroa.setZhuangtai(0);
        docterShiroa.setJuese("医生");
        sds.insert(docterShiroa);
        return "redirect:/doctorfindAll";
    }

    @RequestMapping(value = "/yishengup/{did}", method = RequestMethod.GET)
    public ModelAndView upyisheng(@PathVariable("did") Integer did) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("yishengupdate");
        modelAndView.addObject("doctro", sds.findDoctroBydid(did));
        return modelAndView;
    }

    @RequestMapping(value = "/yishengdel/{did}", method = RequestMethod.GET)
    public String delyisheng(@PathVariable("did") Integer did) {
        sds.deleteSer(did);
        return "redirect:/doctorfindAll";
    }


    @RequestMapping(value = "/updateyisheng", method = RequestMethod.POST)
    public String update(String did, @RequestParam("file") MultipartFile muli, String shijian, String biaoti, String dname, String intro, String intros, String honor, String source) throws UnsupportedEncodingException {
        DocterShiro docterShiro = new DocterShiro();
        docterShiro.setDid(Integer.valueOf(did));
        docterShiro.setIntro(intro);
        docterShiro.setIntros(intros);
        docterShiro.setHonor(honor);
        docterShiro.setSource(source);
        docterShiro.setBiaoti(biaoti);
        docterShiro.setShijian(shijian);
        docterShiro.setDname(dname);
        docterShiro.setZhuangtai(0);
        docterShiro.setJuese("医生");
        String originalFilename = muli.getOriginalFilename();
        if (!originalFilename.equals("")) {
            String upload = uploadUtils.upload(muli);
            docterShiro.setDpic(url + upload);
        }
        sds.updateSer(docterShiro);
        return "redirect:/doctorfindAll";
    }
    @RequestMapping("/doctrofindAll")
    @ResponseBody
    public List<DocterShiro>findAllQ() {
        List<DocterShiro> list = sds.findAll();
        return list;
    }

}

