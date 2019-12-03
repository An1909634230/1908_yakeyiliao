package com.javahao.service.impl;

import com.javahao.pojo.Gallery;
import com.javahao.responsitory.GalleryRepository;
import com.javahao.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;
    @Override
    public List<Gallery> selectAll() {
        return galleryRepository.findAll();
    }

    @Override
    public void delete(Integer sid) {
        galleryRepository.deleteById(sid);
    }

    @Override
    public void update(Gallery gallery) {
        galleryRepository.saveAndFlush(gallery);
    }

    @Override
    public Gallery selectOne(Integer sid) {
        Optional<Gallery> byId = galleryRepository.findById(sid);
        Gallery gallery=null;
        if (byId.isPresent()){
            gallery = byId.get();
        }
        return gallery;
    }

    @Override
    public void insert(Gallery gallery) {
        galleryRepository.save(gallery);
    }
}
