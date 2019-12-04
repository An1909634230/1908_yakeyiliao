package com.javahao.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "success")
@Data
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String spic;
    private String spicx;
}