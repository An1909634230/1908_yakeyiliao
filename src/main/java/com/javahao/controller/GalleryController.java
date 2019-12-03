package com.javahao.controller;

import com.javahao.pojo.Gallery;
import com.javahao.service.GalleryService;
import com.javahao.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class GalleryController {
    @Autowired
    private GalleryService galleryService;
    @Value("${qiniu.url}")
    private  String url;
    @Autowired
    private UploadUtils up;

    @RequestMapping("/{index}")
    public String all(@PathVariable("index") String index) {

        return index;
    }
    @RequestMapping(value = "/gselectAll")
    public String selectAll(Model model){
        List<Gallery> all = galleryService.selectAll();
        model.addAttribute("all",all);
        return "gselectAll";
    }
    @RequestMapping(value = "/gselectOne/{sid}")
    public String selectOne(@PathVariable("sid")Integer sid, Model model){
        Gallery gallery = galleryService.selectOne(sid);
        model.addAttribute("gallery",gallery);
        return "gupdate";
    }
    @RequestMapping(value = "/gdelete/{sid}",method = RequestMethod.GET)
    public String delete(@PathVariable("sid")Integer sid){
        galleryService.delete(sid);
        return "redirect:/gselectAll";
    }
    @RequestMapping(value = "/gupdate")
    public String update(Integer sid){
        galleryService.delete(sid);

        return "redirect:/gselectAll";
    }
//    @RequestMapping(value = "/gupdate", method = RequestMethod.POST)
//    public String update(Gallery gallery,@RequestParam("file")MultipartFile muli) throws Exception{
//
//        String originalFilename = muli.getOriginalFilename();
//
//        if (!originalFilename.equals("")){
//            String upload = up.upload(muli);
//            gallery.setSpic(upload);
//        }
//        galleryService.update(gallery);
//
//
//        return "redirect:/gselectAll";
//    }

    @RequestMapping(value = "/ginsert",method = RequestMethod.POST)
    public String insert(@RequestParam("file") MultipartFile muli) throws UnsupportedEncodingException {
        String upload = up.upload(muli);
        Gallery gallery=new Gallery();
        gallery.setSpic(url + upload);
        galleryService.insert(gallery);
        return "redirect:/gselectAll";
    }
}
