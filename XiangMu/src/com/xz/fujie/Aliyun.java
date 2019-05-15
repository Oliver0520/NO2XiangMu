package com.xz.fujie;

import org.springframework.stereotype.Component;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
@Component
public class Aliyun {

    // ��Ʒ����:��ͨ�Ŷ���API��Ʒ,�����������滻
    private static final String product = "Dysmsapi";
    // ��Ʒ����,�����������滻
    private static final String domain = "dysmsapi.aliyuncs.com";

    // �˴���Ҫ�滻�ɿ������Լ���AK(�ڰ����Ʒ��ʿ���̨Ѱ��)
    private static String accessKeyId = "LTAI2ELxOTeg98BD";
    private static String accessKeySecret = "BgnphDjGa6ME5B9JZ8s7YUpqQs06oN";
    private static String signName = "CRM����ϵͳ";
    private static String identifyingTempleteCode = "SMS_165109439";

  

   

    public static SendSmsResponse sendSms(String mobile, String templateParam, String templateCode)
            throws ClientException {

        // ������������ʱʱ��
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        // ��ʼ��acsClient,�ݲ�֧��region��
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        // ��װ�������-��������������̨-�ĵ���������
        SendSmsRequest request = new SendSmsRequest();

        // ����:�������ֻ���
        request.setPhoneNumbers(mobile);
        // ����:����ǩ��-���ڶ��ſ���̨���ҵ�
        request.setSignName(signName);
        // ����:����ģ��-���ڶ��ſ���̨���ҵ�
        request.setTemplateCode(templateCode);

        // ��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ
        request.setTemplateParam(templateParam);

        // ѡ��-���ж�����չ��(�����������û�����Դ��ֶ�)
        // request.setSmsUpExtendCode("90997");

        // ��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
        request.setOutId("yourOutId");

        // hint �˴����ܻ��׳��쳣��ע��catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

   

    public static SendSmsResponse sendIdentifyingCode(String mobile, String code) {
        try {
            return sendSms(mobile, "{\"code\":\"" + code + "\"}", identifyingTempleteCode);
        } catch (ClientException e) {
            
        }
		return null;
    }
}