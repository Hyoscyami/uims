package com.xushifei.uims.common.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 反射工具类
 * </p>
 *
 * @author xushifei
 * @date 2021/4/30
 */
@Slf4j
public class ReflectionUtils extends org.springframework.util.ReflectionUtils {
    /**
     * 根据class创建对象
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T createObjByClass(Class<T> tClass){
        try {
            return tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("根据:{}创建对象失败",tClass.getCanonicalName());
            return null;
        }
    }

}
