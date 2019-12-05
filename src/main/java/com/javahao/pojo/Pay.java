package com.javahao.pojo;

import lombok.Data;
/**
 * Created by ${licong} on 2019/12/4.
 */
@Data
public class Pay {
    private Double money=8.88;
    private String theme="小豪牙科预约";
    private String url="http://localhost:8080/#/contact";
    private String member;
}
