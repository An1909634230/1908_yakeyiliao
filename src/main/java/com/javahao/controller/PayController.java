package com.javahao.controller;

import com.alipay.api.AlipayApiException;
import com.javahao.util.AlipayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private AlipayUtils alipayUtils;

    @RequestMapping("/pay")
    public String pay(){
        String pay="";
        try {
            pay = alipayUtils.pay();

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
       // System.out.println(pay);
        return pay;
    }

}
