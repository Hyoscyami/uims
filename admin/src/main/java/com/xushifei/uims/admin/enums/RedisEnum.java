package com.xushifei.uims.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * redis枚举
 * </p>
 *
 * @author xushifei
 * @date 2021/4/8
 */
@Getter
@AllArgsConstructor
public enum RedisEnum {
    /**
     * 验证码登录
     */
    CAPTCHA_LOGIN("captcha:login:%s","验证码登录"),
    /**
     * redis启动模式
     */
    SINGLE_MODE("single", "单例模式"),
    SENTINEL_MODE("sentinel", "哨兵模式"),
    CLUSTER_MODE("cluster", "集群模式");
    private final String code;
    private final String msg;

    public boolean eq(final String code) {
        return this.code.equals(code);
    }
}
