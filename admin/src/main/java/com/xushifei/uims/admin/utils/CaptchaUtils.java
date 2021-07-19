package com.xushifei.uims.admin.utils;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.xushifei.uims.admin.dto.req.CaptchaReqDTO;

import java.util.Properties;

/**
 * 验证码生成
 *
 * @author xushifei
 * @since 2021/3/28
 */
public class CaptchaUtils {
  private static final Properties PROPERTIES = new Properties();
  private static final Config CONFIG = new Config(PROPERTIES);
  private static final DefaultKaptcha DEFAULT_KAPTCHA = new DefaultKaptcha();

  static {
    // 图片宽度
    PROPERTIES.setProperty("kaptcha.image.width", "150");
    // 图片高度
    PROPERTIES.setProperty("kaptcha.image.height", "50");
    // 字符集
    PROPERTIES.setProperty("kaptcha.textproducer.char.string", "0123456789");
    // 字符长度
    PROPERTIES.setProperty("kaptcha.testproducer.char.length", "4");
    DEFAULT_KAPTCHA.setConfig(CONFIG);
  }

  /**
   * 生成默认验证码
   *
   * @return
   */
  public static CaptchaReqDTO generateDefaultCaptcha() {
    CaptchaReqDTO captcha = new CaptchaReqDTO();
    captcha.setText(DEFAULT_KAPTCHA.createText());
    captcha.setBufferedImage(DEFAULT_KAPTCHA.createImage(captcha.getText()));
    return captcha;
  }
}
