package com.javahao.service;

import com.javahao.pojo.Gallery;

import java.util.List;

public interface GalleryService {
    List<Gallery> selectAll();
    void delete(Integer sid);
    void update(Gallery gallery);
    Gallery selectOne(Integer sid);
    void insert(Gallery gallery);
}
