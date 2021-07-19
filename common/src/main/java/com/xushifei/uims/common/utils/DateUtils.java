package com.xushifei.uims.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具类
 *
 * @author xushifei
 * @date 2021/6/25
 */
public class DateUtils {
  /** 默认年月日格式 */
  public static DateTimeFormatter DEFAULT_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  /** 默认年月日 时分秒格式 */
  public static DateTimeFormatter DEFAULT_DATE_TIME =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  /**
   * 日期转字符串，默认yyyy-MM-dd格式
   *
   * @param date
   * @return
   */
  public static String toString(LocalDate date) {
    return date.format(DEFAULT_DATE);
  }

  /**
   * 获取当前年月日
   *
   * @return
   */
  public static String getNowDateStr() {
    return LocalDate.now().format(DEFAULT_DATE);
  }

  /**
   * 获取当前年月日时分秒
   *
   * @return
   */
  public static String getNowDateTimeStr() {
    return LocalDate.now().format(DEFAULT_DATE_TIME);
  }
  /**
   * 日期转字符串，默认yyyy-MM-dd格式
   *
   * @param dateTime
   * @return
   */
  public static String toString(LocalDateTime dateTime) {
    return dateTime.format(DEFAULT_DATE_TIME);
  }
}
