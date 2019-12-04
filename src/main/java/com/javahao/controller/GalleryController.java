package com.javahao.controller;

import com.javahao.pojo.Gallery;
import com.javahao.service.GalleryService;
import com.javahao.util.UploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.AccessType;
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
public class GalleryController {
    @Autowired
    private GalleryService gs;
    @Autowired
    private UploadUtils uploadUtils;
    @Value("${qiniu.url}")
    private String url;
    @RequiresPermissions(value = {"find"})
    @RequestMapping("/galleryfind")
    public ModelAndView findAll() {
        List<Gallery> list = gs.findAll();
        ModelAndView m = new ModelAndView("gallery");
        m.addObject("list", list);
        return m;
    }

    @RequestMapping("/galleryadd")
    public String show4() {
        return "galleryadd";
    }


    @RequiresPermissions(value = {"insert"})
    @RequestMapping("/addgallery")
    public String addcar(@RequestParam("file") MultipartFile muli, @RequestParam("filea") MultipartFile mulia) throws UnsupportedEncodingException {
        String upload = uploadUtils.upload(muli);
        String uploada = uploadUtils.upload(mulia);
        Gallery gallery= new Gallery();
        gallery.setSpic(url + upload);
        gallery.setSpicx(url+uploada);
        gs.add(gallery);
        return "redirect:/galleryfind";
    }


    @RequestMapping(value = "/galleryup/{sid}", method = RequestMethod.GET)
    public ModelAndView up(@PathVariable("sid") Integer sid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("galleryupdate");
        modelAndView.addObject("gallery", gs.findGalleryBysid(sid));
        return modelAndView;
    }

    @RequiresPermissions(value = {"update"})
    @RequestMapping(value = "/galleryupdate", method = RequestMethod.POST)
    public String update(String sid, @RequestParam("file") MultipartFile muli,@RequestParam("filea") MultipartFile mulia) throws UnsupportedEncodingException {
        Gallery gallery=new Gallery();
        gallery.setSid(Integer.valueOf(sid));
        String originalFilename = muli.getOriginalFilename();
        if (!originalFilename.equals("")) {
            String upload = uploadUtils.upload(muli);
            gallery.setSpic(url + upload);
        }
        if (!originalFilename.equals("")) {
            String uploada = uploadUtils.upload(mulia);
            gallery.setSpicx(url + uploada);
        }
        gs.updateGallery(gallery);
        return "redirect:/galleryfind";
    }
    @RequiresPermissions(value = {"delete"})
    @RequestMapping(value = "/gallerydel/{sid}", method = RequestMethod.GET)
    public String del(@PathVariable("sid") Integer sid) {
        gs.deleteGallery(sid);
        return "redirect:/galleryfind";
    }


    @RequestMapping("/galleryfindAll")
    @ResponseBody
    public List<Gallery>findAllQ() {
        List<Gallery> list = gs.findAll();
        return list;
    }
}
