package com.javahao.responsitory;

import com.javahao.pojo.LunBo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anzIhao on 2019/12/3.
 */
public interface LunBoResponsitory extends JpaRepository<LunBo, Integer> {
    public LunBo findLunBoBylid(Integer lid);
}
