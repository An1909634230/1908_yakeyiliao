package com.javahao.service;

import com.javahao.pojo.DocterShiro;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/4.
 */
public interface SysDoctroService {
    public DocterShiro findByDoctorName(String username);

    public List<DocterShiro> findAll();

    public void add(DocterShiro docterShiro);

    public DocterShiro findDoctroBydid(Integer did);

    public void updateSer(DocterShiro docterShiro);

    public void deleteSer(Integer did);

    public void insert(DocterShiro docterShiro);
}
