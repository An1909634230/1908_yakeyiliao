package com.javahao.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
/**
 * Created by ${licong} on 2019/12/2.
 */
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600696255";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCWAYn/DEZCq9qfueqGprT6lL+I8tttbdjIWg/RvybzCUOwyA+zSakSdZbxRfX3bg3Na+E5nBkakZ89sKCbg0jM+fMrN1mVfoSv83F8PPcTcQXDr0QWtvSzaml3gcEmcafLxezM7R6NgiC713LbzH5MVco2rAlscT3Gbbytf0w4OvRd7QI29O/ibFY//0pGuSHUVEZUGzeN+wSYWWTapS55JOWNUksiWsrwIxHxHL0QkwdprRyR10RTV+Qk/WvXFrPYMN6jzCT12uts8Ic+3k9o+jkbLkDeM9O1S4Znrvi902k8mT2+9HMdI/Eh0bRSg2EQEzcADrruVPexMoBfYTL/AgMBAAECggEAa92Tc5lJ9KtLPEwePtElloLb8AhijR/OINPSSEsiIOVqjXZvA8dWEnYIIlrichfrSOnoPNromlhYn62g7/LJqMubdloIyxz9IOD3nBTivlIpiPtBBOxurY05ZbwiPhjARiF/FCT2MV9/VlOovjEgKJgQHpw68oXDnCpQ4JmHH275I9FjaOH+/TKpm4JtRP4Xm/IGkl/EvjyZclODWNgFZrzcS4iRM04N6kAc66Oi/OcA1jBS/d8HxrsN+nIP4RXIbhVbQEej4+tLQv9hohAeYhtlnWxHULgDsYoAWg17Jzs4uwPSM4D9akh8tuQNz17j5T8u1EOLphhJt5KkFvUBkQKBgQDeqzQA44Wf3wRCsws/Vh1lb5vuVhnb8JqqrBAWXtGHcwDHmxbvEk+RNxWXwQWg5PZxcZCt4u7FHZ1pajr1amoycoxw2jBA+JivrPLm4jtw6L7g2cwPX4Q6UQ6oyoCwPIZsdtn6Din7QHbjwXel05qE4JWpPnS377w5hlrg+nQk/QKBgQCsddtfrrt79CTSH6rNDEtmjYo7ZQrTXPbhaLZP0W54WJRUqFwJOLxEP7fFlrleKIl8yiioy9yoEpEBfAnn3YOoWNLHx7PsAnplepiB1e3BcrIje2wZBcod/r5Lgg2V3gQptOo/pE0WRS6bG2bL/1AvdgnhC+QWFdudY9MYDrXWqwKBgDcDlZWioSEeuK7CDcVYQWsOaDg6jakJiS0h1dexFZOhlk+6wa/PllkKgws7ZWibKUheBqDvsI6DAqFI3chEwng0VP6M6d8jjJXa5SimPIlo98AWD5S8xK6j2DtbzO++BHhH5RMi7Lxm8PjUk/skjMjHtDJce/n2AUs1Jr7vIkMBAoGBAIfgl8XsUnUX54bSQm0pmaKkM9wWARCEt1LjgHikxof1KnEE8PanB9Yx6aW42jWwdJqoYJ6VeDXH4w2rX9aaNagGy5Nx6XUygqK/k7cACUIYDvhbvtB8OkGluuKdBf0lHlyJ2OHpnn7EZTL5xOVHNDMgqinwh3VLJWv9AY170ZLfAoGAJHEqzqhXA+oah9CvyH4bQIFqHbG4pmyG5qex3Firk6czRdtBKB9oxulrkWxsAYfWf3QVA1T4glXFM/56vyXl8DgRThn3PyobqH6IAf6UqvKxFZ9OMVQRBL5/pfc9SQiphCFJDseUUsdx5JInFm9jY3Jkvx/rBak7MV54XROaHDU=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhK9g6psJS1lYJjZtzy90eLwJgP3iBapnFr4FE1wR6TZspriEs+1s+lJU6ZvaHBchvgvoYH7ArWdIV+Yzh4AwMlM5pA+NCIalvqkdMWJvQ8jJasODTxFSI8VSZO1/DZbWRe7XbtE+CvRDF9KGP/nhte0SsH8yuVXnp1GgKl6DqYT7PFwabFoQNkzoPRJmqzRevxpy0V/7mGDsyTl75kQMyFqq/Ai1SuesRZCsYYnTuDZKTZEqQHRCp6NavBSgPHwtIQLGZhMYZf4qBRzT8aiKKteQpKBNOT8z1CURIK1KcW5vMThDZKEBkg72qGSx9TMYKbxHYyP8pIPF2Uk6vQ9KEQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url ="www.baidu.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url =  "http://localhost:8080";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

