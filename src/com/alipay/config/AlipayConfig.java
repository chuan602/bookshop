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
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCg+EaVowAhsx0qSmMzx20UoiExe758cXFgCXseojA/LAbTcYMGpDgFSf/a3i3BOCMe3CU5wU42jumHv0qwzQPu2iXwQs7y7Amx13cFVti0DbEgw5Vkwo9+pjghK9ia22kd6DhP9fs/BAxDhjVO9juEnu8p1tmCIfroOEs/cyd9XXmR8e72pv0XKEXW+eP528682JRIVFXwugGIrD4/7Qbr5apsqYGV3LMJzc789X1m4YgKirBnA9vZqmvTXE1jR+cytUE6NA40o6Ty5XzEUxAaQBp52iDxTd4hV8xdGa2U3u47NiyGqNsEPLL5yEoteBuJWlmHSI7jZcEjcJCIy+thAgMBAAECggEAb4FMs99D+hQvQdphub6Nq1tcDwEfROj4loQ6y0+iiEAhQltBXlpnjBJkr+J0Y4JVoczx5H4phdWdo7E5Nhvue4iV+0bsQI6NcKpHAmXUm3VYm8+gLzovWJYgD6pl02/l8xen2owUzOQq8qOHTfl35TiLh7oS1fhf7HkCdyN32XjJ1g/EfjcYwZ0xjdI2oKeNtzP6XA/3c/nHeFH5yBEG9eo2wltZ1qIryo8Ht6NGZuuZO5n/qqhI7LMpXPH/i/aUE2D+hQjFqTzglh8IYmFEugzAr7JvpIqUPrd6ZqbKYDKAlxMe49raA/kLQ99ClHbUncXiTTANu8oXWysEcMsuAQKBgQDkDZR4cIK0lqQ2AgcsfxYxZAzWfWxpQbJfnPuUTDD07G00/LFd4wgzCCv9nXkZyOEazKRlNPPZcdfc4xQI+Qf77WZuDG5ODDCAQYgw5kQNAnp6qlfS8Vs5p4hVSfA2BNXf7PXo2NTH78Lci6lDk0zdiffEyqg9OksuZqE3b97J0QKBgQC0si2+FUvLw1PDQnKkELCUOt2emOt9uxQ+lU2y1sSixMjJ0P5aQB8F2ZRFef6039H7oaWVo1ylXhbNJcnzVmZPKRWRIm5GOErZEWkIsABJuyMdbxv+ftXveouIAKAeDfvEE3i47mKkDe2/CMvhsNdQ9r5IQSQewJ6WXKmi8mzckQKBgQCM2o5fLS6tl3VpHiuMIhp0+xSqzeDNyhP/1hfU6pI6VGTHG2P5VyZTTrLM/Bw1/sp6IPdQwznxjc0D0wUm3Zk+0sw3IFpovkKelNsnSLGzT1qStO91jDkKDR25f+drleT7X4IrBPG3Y7D5QxGSeUI6euKbm4f5+S1CRYVBlkkGYQKBgFq5b4AV3zWSf9b04OyBOLdkCuvbabl6GcMGYbmeXaI/3XR/C4Yy1aCxSuHLS9hy3FJUKfhEynp5EEe2ZnxX8Axk22BAgk+dae8s76id/bcHT60yoUKZWj7gL3h8n+gXK0aaZC2t+zbVi340I3HQwXr0ODu9AS6zlax3H/EheQkRAoGAVlMbHJX58pcVotTmG7K5aVy0qohyd06EQbCRH3Oguqnct3fz7H/F3DoqebgXPzwJhvdQeH4MA+vgpWikTnqhhaxQnNgKGTJiL7yT6kJFXcOkXCxnkxIz8JrF9+KCSPZcqaBGazkN8l9wBSDB5Bc4Ryo92wuAmKv8CUjuORyAHUA=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoPhGlaMAIbMdKkpjM8dtFKIhMXu+fHFxYAl7HqIwPywG03GDBqQ4BUn/2t4twTgjHtwlOcFONo7ph79KsM0D7tol8ELO8uwJsdd3BVbYtA2xIMOVZMKPfqY4ISvYmttpHeg4T/X7PwQMQ4Y1TvY7hJ7vKdbZgiH66DhLP3MnfV15kfHu9qb9FyhF1vnj+dvOvNiUSFRV8LoBiKw+P+0G6+WqbKmBldyzCc3O/PV9ZuGICoqwZwPb2apr01xNY0fnMrVBOjQONKOk8uV8xFMQGkAaedog8U3eIVfMXRmtlN7uOzYshqjbBDyy+chKLXgbiVpZh0iO42XBI3CQiMvrYQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/bookstore/jsps/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/bookstore/jsps/pay/return_url.jsp";

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

