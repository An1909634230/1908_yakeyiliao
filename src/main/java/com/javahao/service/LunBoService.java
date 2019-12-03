package com.javahao.service;

import com.javahao.pojo.LunBo;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/3.
 */
public interface LunBoService {
    public List<LunBo> finAll();
    public void add(LunBo lunBo);
    public LunBo findLunBoLid(Integer lid);
    public void updateItems(LunBo lunBo);
    public void deleteLunBo(Integer lid);
}
