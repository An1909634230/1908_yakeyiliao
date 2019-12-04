package com.javahao.service.impl;

import com.javahao.dao.GalleryDao;
import com.javahao.pojo.Gallery;
import com.javahao.responsitory.GalleryResponsitory;
import com.javahao.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/3.
 */
@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryDao gd;
    @Autowired
    private GalleryResponsitory gr;

    @Override
    public List<Gallery> findAll() {
        return gd.findAll();
    }

    @Override
    public void add(Gallery gallery) {
        gr.save(gallery);
    }

    @Override
    public void deleteGallery(Integer sid) {
        gr.deleteById(sid);
    }

    @Override
    public Gallery findGalleryBysid(Integer sid) {
        return gr.findGalleryBysid(sid);
    }

    @Override
    public void updateGallery(Gallery gallery) {
        gr.saveAndFlush(gallery);
    }
}
