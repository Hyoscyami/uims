package com.xushifei.uims.common.utils;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;

import java.io.File;

/**
 * 注释列表，方法正常注释获取
 *
 * @author xushifei
 * @date 2021/6/11
 */
public class ClassUtils {
  /** 加载项目源代码 */
  public static final JavaProjectBuilder BUILDER = new JavaProjectBuilder();

  static {
    BUILDER.addSourceTree(new File("src/main/java/com/xushifei/admin"));
  }

  /**
   * 根据完整路径类名获取类信息
   *
   * @param completeClassName
   * @return
   */
  public static JavaClass getJavaClass(final String completeClassName) {
    return BUILDER.getClassByName(completeClassName);
  }

  /**
   * 根据class对象获取注释信息
   *
   * @param classT
   * @return
   */
  public static JavaClass getJavaClass(Class classT) {
    return getJavaClass(classT.getCanonicalName());
  }

}
