package com.icexxx.util;

import java.util.List;

/**
 * 发送邮件接口
 * 
 * @author IceWater
 * @version 2.0.5
 */
public interface EmailSender {
    /**
     * 发送短信(单个)
     * 
     * @param to 邮件接收者
     * @param title 邮件标题
     * @param content 邮件内容
     * @return 是否发送成功(true-发送成功,false-发送失败)
     * @since 2.0.5
     */
    public boolean send(String to, String title, String content);

    /**
     * 发送邮件(多个)
     * 
     * @param to 邮件接收者
     * @param title 邮件标题
     * @param content 邮件内容
     * @return 是否发送成功(true-发送成功,false-发送失败)
     * @since 2.0.5
     */
    public boolean send(List<String> to, String title, String content);
}
