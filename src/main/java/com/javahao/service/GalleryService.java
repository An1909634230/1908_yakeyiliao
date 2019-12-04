package com.javahao.service;

import com.javahao.pojo.Gallery;
import com.javahao.pojo.Ser;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/3.
 */
public interface GalleryService {

    public List<Gallery> findAll();

    public void add(Gallery gallery);

    public void deleteGallery(Integer sid);

    public Gallery findGalleryBysid(Integer sid);

    public void updateGallery(Gallery gallery);
}
