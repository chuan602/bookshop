package com.alipay.config;

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

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100662090";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC6bXKdRryXCs/nzVP6YO6/1cfOsMgABM0UB84C/M+CqasNehRa8qx/5KYsDiOhxoriqrMSVLtP0q9UdouF63Y7KnpMleAbcN5QLJaDfa4IVY8Rc8cgBGTs5uuUvZ96TGNWDWzkDY+yFt3UBj9ggtqGGUr0oL/ymRh33q6NAQmiFm4C0zqofRSJjm5QKfRDfg8Q6BCYYN0yAgOToUnjiw3Mb1S+Pmvvkp6aoVR4ImY5b+mgb8hADzUJNtKizSri17A2Qw+eJOZzAr/IJ7OcYdiIX8pEW/yhyGrYYx3LwJGerqXq3O2QH1XGTkltj9TegdoeYN0dYR6CkNECHztaPGpdAgMBAAECggEANo6PCx3HVQByBWkeWViCphs+5OrxLKg7B9Cc5lzrsVZL257NVCxOdQMJ6jydCtvaiyjfTM8FHgAPFU232RImQHxW3BDES+OE+7uAtKxUANZhDv9t153Rl06gxJ+ViynNrEIziq25TqnIcyL86xaAMtw2Bk8AvVM2SOYe+N7D3e3odAmBxv1Rzks9sA3niluEOoy0mpJUr3IyYPIR5/ihTZCJ5SSIv1IyjdmhCeZ9ZF+WY3e9D8gQS6k0EiqC+UeE+NgBgXNZuLbOcNz1HYw59GGTT/AolfKfHQR137muU7o9Zmsg+oyQ8s/7vLQ7qDOsKwrMFegodF6pHtD2u3I7tQKBgQDlBRfwQjCuxIKMTp8Xk0MNaU2eQkLs4kSJJVW35lj5sD68lvGXxmnBy+GC/FdqFt4dPQmnRWdwpS/n2fMyJFadM32kKGXQwrvpPZpIcz3V9GJ1KZukTAMtNpjjHWHfqEh380fndTOWo86KTUmGzwA7Ct/cLAbeQkStr9+eQffxNwKBgQDQY9SZzMGAbkHtyc6RdLmCpfL0aIZNgn2VgwuVDvszmGT6ld5gRqVcQMc6Vn3iIpVJDqa2YCa+uLaGrvmypMNG0plJbhLCt4tWazgxPL6E31u4QmpFRdSMzauY4ADinDnt8Q+voNHwPJvFGMYDXBelr+3GN0CePYGTmQSimh3bCwKBgFWB2lc9D1ohSrDCJgoyVGWsfGtrR/uT24ztIJ0B5xSKplHZdah6T0ApNDCosKaOlS2LfZAzjJR1SHajXHbLNH+LGwzwfFs+adSCyJjmVh8NGLmv6Emmi8UUzm51qPZNqYkHj0Au9Sz4SgQ/KQWpQefJfp2A3qubSHMk6DP5Y25vAoGBAL/56AbUGcNOT9BXJMTdinUwmjTNAkTvnPAa7JWiWor6rrQnUtjQ3E+zoZY9zfSAtZS7OZwz0h3LnuNO2NvZa8iYBP0fuYrGekffuMGrWzyfZCjIjoxIu3oHkzjfzBD3qWpptHCwsBcoTrxxiSHZOjO6cksz5YSh1vh5dEqzviNnAoGBANCdfP2d9oyW5Fa3x/1lDzc1kZROyAv9QKFXceIXpuDD5KGCQdHqGnbEcUHwUEynHSNizdBX+y4iWNaUxFOtWbmEteHJk+ZCgkGLc8YIoYjOArOR1BYD+FhDwAaYrEfwCiX7IIW71li9S1UzyWwc1Khp9bJhCKCB/oAJPi6xvW22";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1Qtx6zgKW0VXtmTunWS41Bmj6Nu94jLE1Gcluk7pZUkL1OcjR/W/eaykb4Wh572wNXm77tqkVjqZzXiuS2nfdyyTt88AkARYiFG7Iopt3jf5TCBnPNuPg0XdhJ+SiBToe5fIG8JWQNOmd6ggCmtmP6tr85QinblJ82Rakx8QFhUdOWfdqXGFLWJrJz1r3AcNMFi5MNiDwFCMicOR9atprPdDzlcQvFsSbcTAlscb/suKRZPIo0OQ4oGLugmNzWFx/BIKuV6bgpyWKHzct1gKIA5Cwyp8KN5K0lqDqekLhTABzo1DbEDN5WwCyxcEhdCGVggjHKt7ZumPt96hN7mttwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://120.78.204.18:8080/EyeBook/jsp/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://120.78.204.18:8080/EyesBook/jsp/return_url.jsp";

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
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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

