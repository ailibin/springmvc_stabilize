package com.aiitec.demo.model.comm;

/**
 * 用于测试兼容旧协议的映射对象
 */
public class UserMap {
    public UserRespBody.User user;
    public UserMap(UserRespBody.User user){
        this.user = user;
    }
}
