package com.javahao.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by anzIhao on 2019/12/3.
 */
@Entity
@Data
@Table(name = "lunbo")
public class LunBo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lid;
    private String lpic;
}
