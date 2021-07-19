package com.xushifei.uims.common.constant;

/**
 * 系统常量
 *
 * @author xushifei
 * @since 2021/4/3
 */
public class SysConstants {
  /** 默认登录地址 */
  public static final String DEFAULT_FILTER_PROCESSES_URL = "/operator/login";
  /** 验证码 */
  public static final String CAPTCHA = "captcha";
  /** 根节点ID,parentId为ROOT_ID的节点为根节点 */
  public static final Long ROOT_PARENT_ID = 0L;
  /** 根节点ID */
  public static final Long ROOT_ID = 1L;
  /** 权限类型，菜单 */
  public static final Integer PERMISSION_TYPE_MENU = 1;
  /** 权限类型，按钮 */
  public static final Integer PERMISSION_TYPE_BUTTON = 2;

  // ---------------系统通用状态---------------
  /** 1：启用 */
  public static final Integer STATUS_ENABLE = 1;
  /** 0:禁用 */
  public static final Integer STATUS_DISABLE = 0;
  /** request登录时remember的attribute */
  public static final String REQUEST_REMEMBER_ME = "rememberMe";
  /** 是 */
  public static final String YES = "yes";
  /** 登录校验token名称 */
  public static final String HEADER_TOKEN = "X-Auth-Token";
  /** 导出文件的response.setContentType */
  public static final String EXPORT_FILE_MEDIA_TYPE =
      "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  /** 上传文件保存在服务器的路径 */
  public static final String UPLOAD_FILE_SAVE_PATH = "/data/uploadFile/";
}
