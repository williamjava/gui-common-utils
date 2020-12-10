package com.gui.common.utils.notify;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 短信发送工具类(阿里云)
 *
 * @author wgui
 */
public class SmsSendUtils {
    /**
     * 产品名称:云通信短信API产品,开发者无需替换
     */
    static final String PRODUCT = "Dysmsapi";
    /**
     * 产品域名,开发者无需替换
     */
    static final String DOMAIN = "dysmsapi.aliyuncs.com";

    /**
     *
     * @param phone 手机号
     * @param param 字符串参数 例:"{\"code\":\"123456\"}"
     * @param templateId 模板id
     * @param sign 短信签名
     * @param accessKeyId key
     * @param accessKeySecret 密钥
     * @return code="OK" 成功
     */
    public static SendSmsResponse sendSms(String phone, String param, String templateId, String sign, String accessKeyId, String accessKeySecret){
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号
            request.setPhoneNumbers(phone);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(sign);
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(templateId);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(param);
            SendSmsResponse response = acsClient.getAcsResponse(request);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            SendSmsResponse sendSmsResponse = new SendSmsResponse();
            sendSmsResponse.setCode("-1");
            sendSmsResponse.setMessage("发送短信超时");
            return sendSmsResponse;
        }
    }
}
