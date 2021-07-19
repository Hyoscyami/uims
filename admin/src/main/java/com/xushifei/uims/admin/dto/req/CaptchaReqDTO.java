package com.xushifei.uims.admin.dto.req;

import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * <p>
 * 图片验证码
 * </p>
 *
 * @author xushifei
 * @since 2021/3/28
 */
@Data
public class CaptchaReqDTO {
    /**
     * 图片验证码字符串
     */
    private String text;
    /**
     * 图片验证码字符流
     */
    private BufferedImage bufferedImage;
}
