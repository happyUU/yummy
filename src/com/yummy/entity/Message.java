package com.yummy.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-13 19:21
 */
public class Message {
    //状态码
    private int msgCode;
    //状态信息
    private String msgInfo;

    //用户要返回给浏览器的数据
    private Map<String, Object> msgItems = new HashMap<>();

    private Message() {
    }

    /**
     * 对外提供静态方法，返回成功的Message对象 状态码为200
     *
     * @param msgInfo
     * @return
     */
    public static Message success(String msgInfo) {
        Message message = new Message();
        message.setMsgCode(200);
        message.setMsgInfo(msgInfo);
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgCode=" + msgCode +
                ", msgInfo='" + msgInfo + '\'' +
                '}';
    }

    /**
     * 对外提供静态方法，返回失败的Message对象 状态码为300
     *
     * @param msgInfo
     * @return
     */
    public static Message failed(String msgInfo) {
        Message message = new Message();
        message.setMsgCode(300);
        message.setMsgInfo(msgInfo);
        return message;
    }

    /**
     * 为当前Message对象添加一条要返回的数据
     * 返回Message对象为链式操作提供方便
     *
     * @param key
     * @param value
     * @return
     */
    public Message add(String key, Object value) {
        this.msgItems.put(key, value);
        return this;
    }

    public Map<String, Object> getExtend() {
        return msgItems;
    }

    public void setExtend(Map<String, Object> extend) {
        this.msgItems = extend;
    }

    public int getMsgCode() {
        return msgCode;
    }

    private void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }
}
