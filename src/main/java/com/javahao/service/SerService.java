package com.javahao.service;

import com.javahao.pojo.Ser;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/3.
 */
public interface SerService {
    public List<Ser> findAll();

    public void add(Ser ser);

    public void deleteSer(Integer seid);
    public Ser findSerseid(Integer seid);

    public void updateSer(Ser ser);
}
