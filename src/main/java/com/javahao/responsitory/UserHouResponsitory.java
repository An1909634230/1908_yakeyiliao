package com.javahao.responsitory;

import com.javahao.pojo.UserHou;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anzIhao on 2019/12/4.
 */
public interface UserHouResponsitory extends JpaRepository<UserHou, Integer> {
    public UserHou findUserHouByuid(Integer uid);
}
