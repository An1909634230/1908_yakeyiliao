package com.javahao.controller;

import com.alipay.api.AlipayApiException;
import com.javahao.pojo.Pay;
import com.javahao.util.AlipayUtils;
import com.javahao.util.OrderNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private AlipayUtils alipayUtils;

    //预约充值
    @RequestMapping("/pay")
    public String pay(Pay pay0, String orderNumber) {
        String pay = "";
        try {
            String orderNumber0 = OrderNumberUtils.orderNumber();
            pay = alipayUtils.pay(pay0, orderNumber0);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return pay;
    }

    //充值
    @RequestMapping("/recharge/{money}/{theme}")
    public String recharge(@PathVariable("money") Double money, @PathVariable("theme") String theme) {
        Pay pay0 = new Pay();
        pay0.setMoney(money);
        pay0.setTheme(theme);
        String orderNumber0 = OrderNumberUtils.orderNumber();
        return this.pay(pay0, orderNumber0);
    }

}
