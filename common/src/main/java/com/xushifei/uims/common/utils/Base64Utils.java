package com.xushifei.uims.common.utils;

import java.util.Base64;

/**
 * <p>
 * base64相关
 * </p>
 *
 * @author xushifei
 * @date 2021/4/9
 */
public class Base64Utils {
    /**
     * 渲染base64的jpeg图片前缀
     */
    private static final String JPEG = "data:image/jpeg;base64,";

    /**
     * 获取JPEG的base64编码
     * @param bytes
     * @return
     */
    public static String getJpegBase64(byte[] bytes){
        return JPEG + Base64.getEncoder().encodeToString(bytes);
    }
}