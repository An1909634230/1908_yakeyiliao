package com.javahao.service.impl;

import com.javahao.dao.SerDao;
import com.javahao.pojo.Ser;
import com.javahao.responsitory.SerResponsitory;
import com.javahao.service.SerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/3.
 */
@Service
public class SerServiceImpl implements SerService {
    @Autowired
    private SerDao sd;
    @Autowired
    private SerResponsitory sr;

    @Override
    public List<Ser> findAll() {
        return sd.findAll();
    }

    @Override
    public void add(Ser ser) {
        sr.save(ser);
    }

    @Override
    public void deleteSer(Integer seid) {
        sr.deleteById(seid);
    }

    @Override
    public Ser findSerseid(Integer seid) {
        return sr.findSerByseid(seid);
    }

    @Override
    public void updateSer(Ser ser) {
        sr.saveAndFlush(ser);
    }
}
