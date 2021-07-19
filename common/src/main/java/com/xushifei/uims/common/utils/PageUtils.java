package com.xushifei.uims.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Collections;
import java.util.List;

/**
 * @author xushifei
 * @date 2021/5/17
 */
public class PageUtils {
  /**
   * 空page
   *
   * @param <T>
   * @return
   */
  public static <T> Page<T> emptyDataPage() {
    Page<T> page = new Page<>();
    page.setTotal(0);
    page.setRecords(Collections.emptyList());
    return page;
  }

  /**
   * 组装page
   *
   * @param total
   * @param records
   * @param <T>
   * @return
   */
  public static <T> Page<T> page(Integer total, List<T> records) {
    Page<T> page = new Page<>();
    page.setTotal(total);
    page.setRecords(records);
    return page;
  }
  /**
   * 组装page
   *
   * @param total
   * @param records
   * @param <T>
   * @return
   */
  public static <T> Page<T> page(Long total, List<T> records) {
    Page<T> page = new Page<>();
    page.setTotal(total);
    page.setRecords(records);
    return page;
  }
}
