package com.aiitec.demo.model.util;

/**
 * 判断是否为图片格式的文件
 */
public class VerifyImageFileUtil {

    /**
     * 判断为图片格式的方法
     *
     * @param fileName
     * @return
     */
    public static boolean isImageFile(String fileName) {
        String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
        if (type != null) {
            if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
