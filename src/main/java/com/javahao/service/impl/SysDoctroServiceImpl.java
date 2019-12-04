package com.javahao.service.impl;

import com.javahao.dao.SysDocter;
import com.javahao.pojo.DocterShiro;
import com.javahao.responsitory.SysDoctroResponsity;
import com.javahao.service.SysDoctroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/4.
 */
@Service("sysDoctroService")
public class SysDoctroServiceImpl implements SysDoctroService {
    @Autowired
    private SysDocter sd;
    @Autowired
    private SysDoctroResponsity sr;


    @Override
    public DocterShiro findByDoctorName(String username) {
        return sd.findByDoctorName(username);
    }

    @Override
    public List<DocterShiro> findAll() {
        return sd.findAll();
    }

    @Override
    public void add(DocterShiro docterShiro) {
        sr.save(docterShiro);
    }

    @Override
    public DocterShiro findDoctroBydid(Integer did) {
        return sr.findDocterShiroBydid(did);
    }

    @Override
    public void updateSer(DocterShiro docterShiro) {
        sr.saveAndFlush(docterShiro);
    }

    @Override
    public void deleteSer(Integer did) {
        sr.deleteById(did);
    }

    @Override
    public void insert(DocterShiro docterShiro) {
        sr.save(docterShiro);
    }
}
