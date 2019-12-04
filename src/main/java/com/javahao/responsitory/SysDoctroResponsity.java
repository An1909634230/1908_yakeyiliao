package com.javahao.responsitory;

import com.javahao.pojo.DocterShiro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anzIhao on 2019/12/4.
 */
public interface SysDoctroResponsity extends JpaRepository<DocterShiro, Integer> {
    public DocterShiro findDocterShiroBydid(Integer did);
}
