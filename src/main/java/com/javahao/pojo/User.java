package com.javahao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by anzIhao on 2019/12/2.
 */
@Data
public class User {
    private Integer uid;
    private String uname;
    private String email;
    private String tel;
    private String dname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String symptom;
    private Integer status;
    private String upass;
    private String member;
    private Integer money;
}
