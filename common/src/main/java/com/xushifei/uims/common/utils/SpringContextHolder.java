package com.xushifei.uims.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author xushifei
 * @date 2021/6/16
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContextHolder.applicationContext = applicationContext;
  }

  /**
   * 根据名称获取bean
   *
   * @param name
   * @return
   */
  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }
  /**
   * 根据类型获取bean
   *
   * @param clazz
   * @param <T>
   */
  public static <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }
}
