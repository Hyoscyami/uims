package com.xushifei.uims.common.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author xushifei
 * @date 2021/6/22
 */
@Slf4j
public class ExcelReadListener<T> extends AnalysisEventListener<T> {
  /** 批量清理数量，读取达到该数量则做处理 */
  private static final int BATCH_COUNT = 3000;
  /** 处理list的逻辑 */
  private final Consumer<List<T>> consumer;
  /** 从Excel中读取出来的数据 */
  private final List<T> list;

  public ExcelReadListener(Consumer<List<T>> consumer) {
    this.consumer = consumer;
    this.list = new ArrayList<>();
  }
  /**
   * When analysis one row trigger invoke function.
   *
   * @param data one row value. Is is same as {@link AnalysisContext#readRowHolder()}
   * @param context
   */
  @Override
  public void invoke(T data, AnalysisContext context) {
    this.list.add(data);
    if (this.list.size() >= BATCH_COUNT) {
      this.consumer.accept(this.list);
      this.list.clear();
    }
  }

  /**
   * if have something to do after all analysis
   *
   * @param context
   */
  @Override
  public void doAfterAllAnalysed(AnalysisContext context) {
    consumer.accept(this.list);
  }
}
