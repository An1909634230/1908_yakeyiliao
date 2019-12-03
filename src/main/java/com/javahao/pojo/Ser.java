package com.javahao.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by anzIhao on 2019/12/3.
 */
@Data
@Entity
@Table(name = "service")
public class Ser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seid;
    private String seintro;
    private String sename;
    private String sepic;
}
