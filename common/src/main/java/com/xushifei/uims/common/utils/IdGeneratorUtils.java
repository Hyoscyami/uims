package com.xushifei.uims.common.utils;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 生成id
 *
 * @author xushifei
 * @date 2021/4/9
 */
public class IdGeneratorUtils {
  /**
   * UUID去除横杠
   *
   * @return
   */
  public static String getId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  /**
   * 机构编号
   *
   * @return
   */
  public static String getOrgNo() {
    return String.valueOf(ThreadLocalRandom.current().nextInt(10000000, 99999998 + 1));
  }
}
