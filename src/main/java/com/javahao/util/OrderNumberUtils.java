package com.javahao.util;

import org.springframework.stereotype.Component;

import java.util.Random;
/*随机产生订单编号类*/
@Component
public class OrderNumberUtils {
//    private static char[] array = new char[100];
//    private static char[] arrayOrderNumber = new char[15];
    public static String orderNumber() {
        Random random = new Random();
        double dd = random.nextDouble() / 3.1415927/3.1415927;
       String order_number = Double.toString(dd).substring(2, 16);
       return order_number;
//        int num = 48;
//        int num2 = 97;
//        for (int j = 0; j < array.length; j++) {
//            //if (j < 74) {
//                if (num > 57) {
//                    num = 48;
//                } else {
//                    array[j] = (char) num++;
//                }
////            } else {
//////                array[j] = (char) num2++;
//////            }
//        }
//        for (int i = 0; i < arrayOrderNumber.length; i++) {
//            Random random = new Random();
//            arrayOrderNumber[i] = array[random.nextInt(100)];
//        }
       // return String.valueOf(array);
       // return String.valueOf(arrayOrderNumber);
    }

    public static void main(String[] args) {
        System.out.println(OrderNumberUtils.orderNumber().toCharArray());


    }
}
