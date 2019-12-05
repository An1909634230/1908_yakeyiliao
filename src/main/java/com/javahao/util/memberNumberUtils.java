package com.javahao.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by ${licong} on 2019/12/4.
 */
/*随机产生订单编号类*/
@Component
public class memberNumberUtils {
    public static String memberNumberUtils() {
        Random random = new Random();
        double dd = random.nextDouble() / 3.1415927 / 3.1415927;
        String order_number = Double.toString(dd).substring(2, 10);
        return order_number;
    }
}
