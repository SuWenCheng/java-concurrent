package com.alwin.juc.promise.clouduploader;

import lombok.Data;

@Data
public class CloudSyncConfig {

    /**
     * server端的地址
     */
    private String cloudAddress;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 上次到个人网盘的目录
     */
    private String serverDir;

}
