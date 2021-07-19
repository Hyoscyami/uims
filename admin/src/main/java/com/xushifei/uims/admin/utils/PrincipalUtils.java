package com.xushifei.uims.admin.utils;

import com.xushifei.uims.admin.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * <p>
 * spring security 用户相关
 * </p>
 *
 * @author xushifei
 * @date 2021/4/25
 */
public class PrincipalUtils {
    /**
     * 获取当前登录用户
     * @return
     */
    public static User getPrincipal(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
