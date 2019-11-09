package com.icexxx.util;

import java.util.List;

/**
 * 发送短信接口
 * 
 * @author IceWater
 * @version 2.0.5
 */
public interface SmsSender {
    /**
     * 发送短信(单个)
     * 
     * @param phone 手机号
     * @param content 发送的内容
     * @return 是否发送成功(true-发送成功,false-发送失败)
     * @since 2.0.5
     */
    public boolean send(String phone, String content);

    /**
     * 发送短信(单个)
     * 
     * @param phone 手机号
     * @param content 发送的内容
     * @param signName 短信签名
     * @return 是否发送成功(true-发送成功,false-发送失败)
     * @since 2.0.5
     */
    public boolean send(String phone, String content, String signName);

    /**
     * 发送短信(多个)
     * 
     * @param phone 手机号
     * @param content 发送的内容
     * @param signName 短信签名
     * @return 是否发送成功(true-发送成功,false-发送失败)
     * @since 2.0.5
     */
    public boolean send(List<String> phone, String content, String signName);
}
