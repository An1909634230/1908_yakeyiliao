package com.javahao.pojo;

import lombok.Data;


import javax.persistence.*;

import java.util.Date;

/**
 * Created by anzIhao on 2019/12/4.
 */
@Entity
@Table(name = "user")
@Data
public class UserHou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String uname;
    private String email;
    private String tel;
    private String dname;
    @Temporal(TemporalType.DATE)
    private Date data;
    private String symptom;
    private String member;
    private Integer money;
}
