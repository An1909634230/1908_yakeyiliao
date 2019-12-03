package com.javahao.service.impl;

import com.javahao.dao.LunBoDao;
import com.javahao.pojo.LunBo;
import com.javahao.responsitory.LunBoResponsitory;
import com.javahao.service.LunBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/3.
 */
@Service
public class LunBoServiceImpl implements LunBoService {
    @Autowired
    private LunBoDao lb;
    @Autowired
    private LunBoResponsitory lr;

    @Override
    public List<LunBo> finAll() {
        return lb.finAll();
    }

    @Override
    public void add(LunBo lunBo) {
        lr.save(lunBo);
    }

    @Override
    public LunBo findLunBoLid(Integer lid) {
        return lr.findLunBoBylid(lid);
    }

    @Override
    public void updateItems(LunBo lunBo) {
        lr.saveAndFlush(lunBo);
    }

    @Override
    public void deleteLunBo(Integer lid) {
        lr.deleteById(lid);
    }
}
