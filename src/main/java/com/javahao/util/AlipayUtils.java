package com.javahao.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.javahao.config.AlipayConfig;
import com.javahao.pojo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by ${licong} on 2019/12/4.
 */
@Slf4j
@Component
public class AlipayUtils {

    public String pay(Pay pay,String orderNumber) throws AlipayApiException {

        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", "utf-8", AlipayConfig.alipay_public_key, "RSA2");
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        //支付完成返回要去的页面
        alipayRequest.setReturnUrl(pay.getUrl());
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //订单编号
        String order_number=null;
        if(orderNumber!=null){
          order_number=orderNumber;
        }else{
            Random random = new Random();
            double dd = random.nextDouble() / 3.1415927/3.1415927;
            order_number = Double.toString(dd).substring(2, 20);
        }
        System.out.println(order_number);
        //付款钱数赋值
        double money = pay.getMoney();
        //付款主题
        String subject = pay.getTheme();
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + order_number + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + money + "," +
                "    \"subject\":\"" + subject + "\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"20885118332078462\"" +
                "    }" +
                "  }");
        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //输出
        log.info("返回结果={}", result);
        return result;
    }
}