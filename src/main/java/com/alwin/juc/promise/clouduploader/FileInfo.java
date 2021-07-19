package com.alwin.juc.promise.clouduploader;

import lombok.Data;

@Data
public class FileInfo {

    /**
     * 文件
     */
    private byte[] file;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Integer fileSize;

}
