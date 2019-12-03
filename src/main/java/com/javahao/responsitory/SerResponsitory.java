package com.javahao.responsitory;

import com.javahao.pojo.Ser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anzIhao on 2019/12/3.
 */
public interface SerResponsitory extends JpaRepository<Ser, Integer> {
    public Ser findSerByseid(Integer seid);
}
