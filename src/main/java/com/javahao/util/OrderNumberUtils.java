package com.javahao.util;

import org.springframework.stereotype.Component;

import java.util.Random;
/*随机产生订单编号类*/
@Component
public class OrderNumberUtils {
    private static char[] array = new char[36];
    private static char[] arrayOrderNumber = new char[18];

    public static String orderNumber() {
        int num = 48;
        int num2 = 97;
        for (int j = 0; j < array.length; j++) {
            if (j < 10) {
                array[j] = (char) num++;
            } else {
                array[j] = (char) num2++;
            }
        }
        for (int i = 0; i < arrayOrderNumber.length; i++) {
            Random random = new Random();
            array[i] = array[random.nextInt(36)];
        }

        return String.valueOf(array);

    }
    public static void main(String[] args) {
        System.out.println(OrderNumberUtils.orderNumber().toCharArray());

    }
}
