package com.javahao.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by anzIhao on 2019/12/4.
 */
@Data
@Entity
@Table(name = "doctor")
public class DocterShiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;
    private String dname;
    private String password;
    private Integer zhuangtai;
    private String juese;
    private String dpic;
    private String intro;
    private String intros;
    private String honor;
    private String source;
    private String shijian;
    private String biaoti;
}
