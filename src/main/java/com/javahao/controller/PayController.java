package com.javahao.controller;

import com.alipay.api.AlipayApiException;
import com.javahao.pojo.Pay;
import com.javahao.pojo.User;
import com.javahao.service.UserService;
import com.javahao.util.AlipayUtils;
import com.javahao.util.OrderNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ${licong} on 2019/12/2.
 */
@RestController
public class PayController {

    @Autowired
    private AlipayUtils alipayUtils;
    @Autowired
    private UserService userService;

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
    @RequestMapping(value = "/recharge",method = RequestMethod.POST)
    public String recharge(@RequestBody Pay pay) {
        User user =new User() ;
        user.setMember(pay.getMember());
        user.setMoney(pay.getMoney());
        System.err.println(pay);
        String orderNumber0 = OrderNumberUtils.orderNumber();
        userService.memberMoney(user);
        return this.pay(pay, orderNumber0);
    }
    //查询余额
    @RequestMapping(value = "/inquire",method = RequestMethod.POST)
    public Double inquire(@RequestBody Pay pay) {
        Double user = userService.inquire(pay.getMember());
        return user;
    }
}
